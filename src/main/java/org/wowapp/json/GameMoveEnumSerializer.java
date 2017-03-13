package org.wowapp.json;

import java.io.IOException;

import org.wowapp.game.GameMoveEnum;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class GameMoveEnumSerializer extends JsonSerializer<GameMoveEnum> {

	@Override
	public void serialize(GameMoveEnum value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeStartObject();
        gen.writeNumberField(GameMoveEnum.VALUE_NAME, value.getValue());
        gen.writeObjectField(GameMoveEnum.VIEW_NAME, value.getView());
        gen.writeEndObject();
	}

}
