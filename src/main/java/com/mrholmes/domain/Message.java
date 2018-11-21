package com.mrholmes.domain;

import java.util.Date;

import com.mrholmes.enums.MessageOrigin;

public class Message {

	private String text;
	private MessageOrigin origin;
	private Date time;
	
	public Message() {
		super();
	}
	
	public Message(String text, MessageOrigin origin, Date time) {
		super();
		this.text = text;
		this.origin = origin;
		this.time = time;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public MessageOrigin getOrigin() {
		return origin;
	}
	public void setOrigin(MessageOrigin origin) {
		this.origin = origin;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Message [text=" + text + ", origin=" + origin + ", time=" + time + "]";
	}
}