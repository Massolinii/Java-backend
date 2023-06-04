package com.epicode.GodFathersPizza.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.GodFathersPizza.model.Drink;
import com.epicode.GodFathersPizza.model.DrinkLemonade;
import com.epicode.GodFathersPizza.model.DrinkWater;
import com.epicode.GodFathersPizza.model.FranchiseMug;
import com.epicode.GodFathersPizza.model.FranchiseShirt;
import com.epicode.GodFathersPizza.model.Menu;
import com.epicode.GodFathersPizza.model.Pizza;
import com.epicode.GodFathersPizza.model.PizzaFamilySize;
import com.epicode.GodFathersPizza.model.PizzaHawaii;
import com.epicode.GodFathersPizza.model.PizzaMargherita;
import com.epicode.GodFathersPizza.model.PizzaSalami;
import com.epicode.GodFathersPizza.model.ToppingCheese;
import com.epicode.GodFathersPizza.model.ToppingOnion;
import com.epicode.GodFathersPizza.model.ToppingSalami;

@Configuration
public class MenuConfiguration {
	
	@Bean
	Menu menu() {
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
