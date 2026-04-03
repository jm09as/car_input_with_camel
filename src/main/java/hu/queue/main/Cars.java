package hu.queue.main;

import lombok.Getter;

import java.util.List;

@Getter
public enum Cars {
    ITALY_CARS(List.of("Ferrari", "Fiat", "Alfa Romeo")),
    GERMAN_CARS(List.of("Bmw", "Audi", "Mercedes", "Porsche")),
    AMERICAN_CARS(List.of("Dodge", "Ram", "Chevrolet", "Ford")),
    OTHER(List.of());

    final List<String> cars;

    Cars(List<String> cars) {
        this.cars = cars;
    }

}
