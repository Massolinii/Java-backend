package com.epicode.workSpaceReservationApplication.configuration;

import java.util.Locale;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.workSpaceReservationApplication.enums.SpaceTypology;
import com.epicode.workSpaceReservationApplication.model.Space;
import com.github.javafaker.Faker;

@Configuration
public class SpaceConfiguration {
    @Bean("WorkspaceNoParamsBean")
    @Scope("prototype")
    Space workspaceNoParams() {
        return new Space();
    }

    @Bean("WorkspaceWithParamsBean")
    @Scope("prototype")
    Space workspaceWithParams(
            String name,
            String description,
            SpaceTypology type,
            int maxOccupancy) {
        return new Space(name, description, type, maxOccupancy);
    }

    @Bean("WorkspaceFakeBean")
    @Scope("prototype")
    Space workspaceFake() {
        Faker faker = new Faker(new Locale("it"));
        Random random = new Random();
        String name = faker.gameOfThrones().character();
        String description = faker.company().catchPhrase();
        SpaceTypology type = SpaceTypology.values()[random.nextInt(
        		SpaceTypology.values().length)];
        int maxOccupancy = faker.number().numberBetween(1, 40);
        return new Space(name, description, type, maxOccupancy);
    }

}
