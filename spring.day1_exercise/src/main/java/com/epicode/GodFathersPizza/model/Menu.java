package com.epicode.GodFathersPizza.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Menu {
	
	 private List<Pizza> menuPizza = new ArrayList<Pizza>();
	 private List<Drink> menuDrink = new ArrayList<Drink>();
	 private List<Topping> menuTopping = new ArrayList<Topping>();
	 private List<Franchise> menuFranchise = new ArrayList<Franchise>();
}
