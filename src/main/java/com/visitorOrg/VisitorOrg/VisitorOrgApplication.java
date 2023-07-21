package com.visitorOrg.VisitorOrg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class VisitorOrgApplication  {

	public static void main(String[] args) {
		SpringApplication.run(VisitorOrgApplication.class, args);
	}

}
