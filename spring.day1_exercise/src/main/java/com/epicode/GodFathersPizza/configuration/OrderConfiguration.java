package com.epicode.GodFathersPizza.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.GodFathersPizza.model.Order;
import com.epicode.GodFathersPizza.model.Table;

@Configuration
public class OrderConfiguration {
	
	@Bean
	@Scope("prototype")
	public Order order() {
		return new Order();
	}
	
	@Bean
	@Scope("prototype")
	Order table() {
		return new Table();
	}

}
