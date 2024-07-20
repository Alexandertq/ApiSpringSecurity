package com.alex;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AlexTrApplication  /*implements CommandLineRunner*/ {

	public static void main(String[] args) {
		SpringApplication.run(AlexTrApplication.class, args);
	}

/*	public void run(String... args) throws Exception {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		System.out.println("a123: " + bCrypt.encode("a123"));
	}*/
}
