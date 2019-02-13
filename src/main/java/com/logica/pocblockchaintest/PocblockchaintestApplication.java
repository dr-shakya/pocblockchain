package com.logica.pocblockchaintest;

import com.logica.pocblockchaintest.configuration.WebjConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocblockchaintestApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(PocblockchaintestApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Poc blockchain");
		SpringApplication.run(PocblockchaintestApplication.class, args);
	}

}

