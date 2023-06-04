package com.epicode.GodFathersPizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epicode.GodFathersPizza.configuration.MenuConfiguration;
import com.epicode.GodFathersPizza.model.Menu;

@SpringBootApplication
public class GodFathersPizzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GodFathersPizzaApplication.class, args);
		
	}

}
