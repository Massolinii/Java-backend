package com.epicode.spring.day1_exercise.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.spring.day1_exercise.model.Drink;
import com.epicode.spring.day1_exercise.model.DrinkLemonade;
import com.epicode.spring.day1_exercise.model.DrinkWater;
import com.epicode.spring.day1_exercise.model.FranchiseMug;
import com.epicode.spring.day1_exercise.model.FranchiseShirt;
import com.epicode.spring.day1_exercise.model.Menu;
import com.epicode.spring.day1_exercise.model.Pizza;
import com.epicode.spring.day1_exercise.model.PizzaFamilySize;
import com.epicode.spring.day1_exercise.model.PizzaHawaii;
import com.epicode.spring.day1_exercise.model.PizzaMargherita;
import com.epicode.spring.day1_exercise.model.PizzaSalami;
import com.epicode.spring.day1_exercise.model.ToppingCheese;
import com.epicode.spring.day1_exercise.model.ToppingOnion;
import com.epicode.spring.day1_exercise.model.ToppingSalami;

@Configuration
public class MenuConfiguration {
	
	@Bean
	public Menu menu() {
		Menu m = new Menu();
		
//		List<Pizza> listaPizze = m.getMenuPizza();
//		PizzaMargherita pm = pizzaMargherita();
//		listaPizze.add(pm);
		
		
		m.getMenuPizza().add(pizzaMargherita());
		m.getMenuPizza().add(PizzaHawaii());
		m.getMenuPizza().add(PizzaSalami());
		m.getMenuPizza().add(pizzaFamilySize(pizzaMargherita()));
		
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
	
	@Bean
	public PizzaFamilySize pizzaFamilySize(Pizza p) {
		return new PizzaFamilySize(p);
	}
	
	@Bean
	public Drink drinkWater() {
		return new DrinkWater();
	}
	
	@Bean
	public Drink drinkLemonade() {
		return new DrinkLemonade();
	}
	
	@Bean
	public ToppingCheese toppingCheese() {
		return new ToppingCheese();
	}
	
	@Bean
	public ToppingOnion toppingOnions() {
		return new ToppingOnion();
	}
	
	@Bean
	public ToppingSalami toppingSalami() {
		return new ToppingSalami();
	}
	
	@Bean
	public FranchiseMug franchiseMug() {
		return new FranchiseMug();
	}
	
	@Bean
	public FranchiseShirt franchiseShirt() {
		return new FranchiseShirt();
	}
}
