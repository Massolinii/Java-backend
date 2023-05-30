package com.epicode.spring.day1_exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epicode.spring.day1_exercise.configuration.MenuConfiguration;
import com.epicode.spring.day1_exercise.model.Menu;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		configWith_Bean();
	}
	
	public static void configWith_Bean() {
		// Creo un Container dove utilizzare i bean sulla base del file di configurazione ConfigurationTest creato
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MenuConfiguration.class);
		
		// Recupero il Bean Menu
		Menu menu = (Menu) appContext.getBean("menu");
		System.out.println("******* Menu *******");
		System.out.println("PIZZAS");
		menu.getMenuPizza().forEach(p -> System.out.println(p.getMenuItems()));
		System.out.println("TOPPINGS");
		menu.getMenuTopping().forEach(t -> System.out.println(t.getMenuItems()));
		System.out.println("DRINKS");
		menu.getMenuDrink().forEach(d -> System.out.println(d.getMenuItems()));
		System.out.println("FRANCHISE");
		menu.getMenuFranchise().forEach(o -> System.out.println(o.getMenuItems()));
		
		// Chiudo il Context
		appContext.close();
	}

}
