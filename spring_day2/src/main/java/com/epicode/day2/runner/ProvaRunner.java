package com.epicode.day2.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProvaRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Prova Run");
		
	}

}
