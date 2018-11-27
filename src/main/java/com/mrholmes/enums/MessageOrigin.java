package com.mrholmes.enums;

public enum MessageOrigin {

	HUMAN("HUMAN"), ROBOT("ROBOT");
	
	public String value;
	
	MessageOrigin(String value) {
		this.value = value;
	}
}