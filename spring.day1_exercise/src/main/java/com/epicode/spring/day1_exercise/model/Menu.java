package com.epicode.spring.day1_exercise.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Menu {
	
	 private List<Pizza> menuPizza = new ArrayList<Pizza>();
	 private List<Drink> menuDrink = new ArrayList<Drink>();
	 private List<PizzaTopping> menuTopping = new ArrayList<PizzaTopping>();
	 private List<Gifts> menuGift = new ArrayList<Gifts>();
}
