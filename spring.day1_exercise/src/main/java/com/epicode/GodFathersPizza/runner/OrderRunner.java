package com.epicode.GodFathersPizza.runner;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epicode.GodFathersPizza.configuration.OrderConfiguration;
import com.epicode.GodFathersPizza.configuration.TableConfiguration;
import com.epicode.GodFathersPizza.model.Menu;
import com.epicode.GodFathersPizza.model.Order;
import com.epicode.GodFathersPizza.model.OrderStatus;
import com.epicode.GodFathersPizza.model.Table;
import com.epicode.GodFathersPizza.model.TableStatus;

public class OrderRunner implements CommandLineRunner {
	
	static Map<Integer, Table> tableList = new HashMap<Integer, Table>();

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run Order Runner...");
		configTableWith_Bean();
		configOrderWith_Bean();
		
	}
	
	public static void configTableWith_Bean() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(TableConfiguration.class);
		
		// Recupero il Bean Tavolo
		Table table1 = (Table) appContext.getBean("tavolo", 1, 4);
		Table table2 = (Table) appContext.getBean("tavolo", 2, 2);
		Table table3 = (Table) appContext.getBean("tavolo", 3, 6);
		
		tableList.put(table1.getTableNumber(), table1);
		tableList.put(table2.getTableNumber(), table3);
		tableList.put(table2.getTableNumber(), table3);
		
		System.out.println(tableList.get(1));
		System.out.println(tableList.get(2));
		System.out.println(tableList.get(3));
		
		System.out.println("******* TABLE *******");
		Table table = (Table) appContext.getBean("table");
		table.setTableStatus(TableStatus.FREE);
		table.setMaxSeats(4);
		table.setTableNumber(1);
		
	}
	
	public static void configOrderWith_Bean() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(OrderConfiguration.class);
		
		System.out.println("******* ORDER *******");
		Order order1 = (Order) appContext.getBean("order", 1, tableList.get(1), 2);
		order1.setTable(table);
		order1.setTime(LocalDateTime.now());
		order1.setOrderStatus(OrderStatus.IN_PROGRESS);
		order1.setOrderNumber(1);
		order1.setSeats(4);
		
		System.out.println(order1);
	}
}
