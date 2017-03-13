package org.wowapp.game;

import org.wowapp.json.GameMoveEnumDeserializer;
import org.wowapp.json.GameMoveEnumSerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using=GameMoveEnumSerializer.class)
@JsonDeserialize(using=GameMoveEnumDeserializer.class)
public enum GameMoveEnum {
	PAPER(0,"Paper"),
	ROCK(1,"Rock"),
	SCISSORS(2,"Scissors");
	
	public static final String VALUE_NAME = "value";
	public static final String VIEW_NAME = "view";
	
	private final int value;
	
	private final String view;
	
	private GameMoveEnum(int value, String view) {
		this.value = value;
		this.view = view;
	}
	
	public static GameMoveEnum fromView(String view) {
		return GameMoveEnum.valueOf(view);
	}
	
	public static GameMoveEnum fromValue(int value) {
		int length = GameMoveEnum.values().length;
		int position = value;
		if (position < 0) {
			position = 0;
		} else if (position >= length) {
			position = length - 1;
		}
		return GameMoveEnum.values()[position];
	}

	public int getValue() {
		return value;
	}

	public String getView() {
		return view;
	}
}
