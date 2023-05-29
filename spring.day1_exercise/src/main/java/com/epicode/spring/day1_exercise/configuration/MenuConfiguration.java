package com.epicode.spring.day1_exercise.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.spring.day1_exercise.model.Menu;
import com.epicode.spring.day1_exercise.model.Pizza;
import com.epicode.spring.day1_exercise.model.PizzaHawaii;
import com.epicode.spring.day1_exercise.model.PizzaMargherita;
import com.epicode.spring.day1_exercise.model.PizzaSalami;

@Configuration
public class MenuConfiguration {
	
	@Bean
	public Menu menu() {
		Menu m = new Menu();
		
//		List<Pizza> listaPizze = m.getMenuPizza();
//		PizzaMargherita pm = pizzaMargherita();
//		listaPizze.add(pm);
		
		
		menu().getMenuPizza().add(pizzaMargherita());
		menu().getMenuPizza().add(PizzaHawaii());
		menu().getMenuPizza().add(PizzaSalami());
		
		return m;
	}
	
	@Bean
	public PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita();
	}
	
	@Bean
	public PizzaHawaii PizzaHawaii() {
		return new PizzaHawaii();
	}
	
	@Bean
	public PizzaSalami PizzaSalami() {
		return new PizzaSalami();
	}
}
