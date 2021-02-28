package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Showroom {
    private static final long BUY_CAR = 2;
    final Seller seller = new Seller(this);
    List<Car> cars = new ArrayList<>();

    public void buySomething() {
        synchronized (seller) {
            System.out.println(Thread.currentThread().getName() + ": Buys");
            try {
                TimeUnit.SECONDS.sleep(BUY_CAR);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": Go home.");
        }
    }

    public Car sellCar() {
        return seller.sellCar();
    }

    public void acceptCar() {
        seller.receiveCar();
    }

    List<Car> getCars() {
        return cars;
    }
}
