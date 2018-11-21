package com.mrholmes.mrholmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mrholmes.util.MrHolmesUtil;

@SpringBootApplication(scanBasePackages={"com.mrholmes.rest.service","com.mrholmes.controller","com.mrholmes.filter"})
public class MrholmesApplication {

	public static void main(String[] args) {
		MrHolmesUtil.say("Iniciando os trabalhos...");
		SpringApplication.run(MrholmesApplication.class, args);
	}
}
