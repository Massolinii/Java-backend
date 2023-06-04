package com.epicode.GodFathersPizza.runner;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.epicode.GodFathersPizza.configuration.MenuConfiguration;
import com.epicode.GodFathersPizza.configuration.OrderConfiguration;
import com.epicode.GodFathersPizza.configuration.TableConfiguration;
import com.epicode.GodFathersPizza.model.Menu;
import com.epicode.GodFathersPizza.model.Order;
import com.epicode.GodFathersPizza.model.OrderStatus;
import com.epicode.GodFathersPizza.model.Table;
import com.epicode.GodFathersPizza.model.TableStatus;

@Component
public class MenuRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Run Menu Runner...");
		configMenuWith_Bean();
		
	}
	
	public static void configMenuWith_Bean() {
		// Creo un Container dove utilizzare i bean sulla base del file di configurazione ConfigurationTest creato
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MenuConfiguration.class);
		
		// Recupero il Bean Menu
		Menu menu = (Menu) appContext.getBean("menu");
		System.out.println("******* MENU *******");
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
