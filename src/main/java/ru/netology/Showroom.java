package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Showroom {
    final Manufacturer seller = new Manufacturer(this);
    List<Car> cars = new ArrayList<>();

    public Car sellCar() {
        return seller.sellCar();
    }

    public void acceptCar() {
        seller.createCar();
    }

    List<Car> getCars() {
        return cars;
    }
}
