package com.mrholmes.strategy;

import java.util.List;

import org.springframework.core.env.Environment;

import com.mrholmes.domain.Message;

public interface HolmesActionReply{
	
	public List<Message> reply(String text, Environment environment) throws Exception;
}