package org.wowapp.json;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

import org.wowapp.game.GameMoveEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class GameMoveEnumDeserializer extends JsonDeserializer<GameMoveEnum> {
	
	@Override
	public GameMoveEnum deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		ObjectMapper mapper = (ObjectMapper) p.getCodec();
	    ObjectNode root = (ObjectNode) mapper.readTree(p);
	    
	    Iterator<Entry<String, JsonNode>> elementsIterator = root.fields();
	    
	    while (elementsIterator.hasNext())
	    {
	    	Entry<String, JsonNode> element=elementsIterator.next();
	    	String name = element.getKey();
	    	if (GameMoveEnum.VALUE_NAME.equals(name)) {
	    		return GameMoveEnum.fromValue(element.getValue().asInt());
	    	}
	    }
		return null;
	}

}
