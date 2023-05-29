package com.epicode.spring.springd1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Springd1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springd1Application.class, args);
		
		//Metodo 1
		//Configurazione tramite classe @Configuration
		//configWith_Bean();
		
		//Metodo 2
		//Configurazione tramite classe @Configuration
		//configWith_Bean();
	}
	
	public static void configWith_Bean() {
		
		// Creo un Container dove utilizzare i Bean sulla base del file di configurazione ConfigurationTest creato
		AnnotationConfigApplicationContext appContext =new AnnotationConfigApplicationContext(ConfigurationTest.class);
		
		
		// Recupero il Bean test
		Test t1 = (Test) appContext.getBean("test");
		System.out.println(t1.readTxt());
		
		// Recupero il Bean paramTest
		// getBean(param1: nome del bean, param2: parametri da passare al bean, ...param)
		Test t2 = (Test) appContext.getBean("paramTest", "Costruzione Bean con 1 parametro");
		System.out.println(t2.readTxt());
		
		// Recupero il Bean paramAllTest
		// getBean(param1: nome del bean, param2: parametri da passare al bean, ...param)
		Test t3 = (Test) appContext.getBean("paramAllTest", "Terzo Bean", "Costruzione Bean con 2 parametri");
		System.out.println(t3.readTxt());
		
		// Chiudo il context
		appContext.close();
	}
	
	public static void configWithXML() {
		
	}

}
