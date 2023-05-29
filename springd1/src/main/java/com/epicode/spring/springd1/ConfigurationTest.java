package com.epicode.spring.springd1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class ConfigurationTest {
	
	// Crea un bean di tipo Test
	@Bean
	@Scope("singleton")
	public Test test() {
		return new Test("Primo Bean", "Costruzione di un Bean da file Configuration");
	}
	
	// Crea un bean di tipo Test
	@Bean
	@Scope("prototype")
	public Test paramTest(String txt) {
		return new Test("Secondo Bean", txt);
	}
	
	// Crea un bean di tipo Test
	@Bean
	@Scope("prototype")
	public Test paramAllTest(String title, String txt) {
		return new Test(title, txt);
	}

}
