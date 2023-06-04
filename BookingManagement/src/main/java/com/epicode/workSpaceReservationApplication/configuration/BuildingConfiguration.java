package com.epicode.workSpaceReservationApplication.configuration;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;
import com.epicode.workSpaceReservationApplication.enums.RandomCities;
import com.epicode.workSpaceReservationApplication.model.Building;
import com.epicode.workSpaceReservationApplication.model.City;
import com.epicode.workSpaceReservationApplication.model.Space;
import com.epicode.workSpaceReservationApplication.repository.CityRepository;



@Configuration
public class BuildingConfiguration {
	
	private final CityRepository cityRepository;

    public BuildingConfiguration(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Bean("BuildingWithParamsBean")
    @Scope("prototype")
    Building buildingWithParams(String name, String address, City city) {
        return new Building(name, address, city);
    }

    @Bean("BuildingNoParamsBean")
    @Scope("prototype")
    Building buildingNoParams() {
        return new Building();
    }

    @Bean("BuildingFakeBean")
    @Scope("prototype")
    Building buildingFake() {
        Faker faker = new Faker(new Locale("it", "it"));
        String name = faker.company().name();
        String address = faker.address().streetAddress();

        RandomCities[] cities = RandomCities.values();
        Random random = new Random();
        RandomCities randomCity = cities[random.nextInt(cities.length)];

        String cityName = randomCity.name();
        List<Space> spaces = cityRepository.findByName(cityName);

        if (spaces.isEmpty()) {
            throw new IllegalArgumentException("No City found with name: " + cityName);
        }
        Space space = spaces.get(0);
        Building building = space.getBuilding();
        if (building == null) {
            throw new IllegalArgumentException("No Building found for Space with ID: " + space.getId());
        }
        City city = building.getCity();
        if (city == null) {
            throw new IllegalArgumentException("No City found for Building with ID: " + building.getId());
        }

        return new Building(name, address, city);
    }
}
