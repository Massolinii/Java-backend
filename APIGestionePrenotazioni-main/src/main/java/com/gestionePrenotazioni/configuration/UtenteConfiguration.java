package com.gestionePrenotazioni.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.gestionePrenotazioni.model.Utente;
import com.github.javafaker.Faker;

@Configuration
public class UtenteConfiguration {

	@Bean
	@Scope("prototype")
	public Utente FakeUtente() {
		Faker fake= Faker.instance(new Locale("it-IT"));
		Utente fakeUtente=new Utente();
		fakeUtente.setNome(fake.name().firstName());
		fakeUtente.setUsername(fakeUtente.getNome().toLowerCase());
		fakeUtente.setEmail(fakeUtente.getUsername()+"@icloud.com");
		return fakeUtente;
	}
}
