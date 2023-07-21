package com.visitorOrg.VisitorOrg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
	private static Logger log = LoggerFactory.getLogger(CommandLineRunner.class);

	@Autowired
	VisitorRepository visitorRepository;

	@Override
	public void run(String... args) throws Exception {
		log.info("Application is started");

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Visitor v1 = new Visitor();
		v1.setFirstName("Mona");
		v1.setLastName("Magdić");
		v1.setDateOfReservation(formatter.parse("2023-04-01"));
		v1.setDateVisitStart(formatter.parse("2023-08-01"));
		v1.setDateVisitEnd(formatter.parse("2023-08-10"));
		visitorRepository.save(v1);

		log.info("V1: " + v1);


	}
}
