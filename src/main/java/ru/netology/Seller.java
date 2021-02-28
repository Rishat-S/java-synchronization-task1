package ru.netology;

import java.util.concurrent.TimeUnit;

public class Seller {
    private static final long ACCEPTANCE_OF_CAR = 2;
    public static final int SOLD_CAR = 1;
    private final Showroom showroom;

    public Seller(Showroom showroom) {
        this.showroom = showroom;
    }

    public synchronized Car sellCar() {
        try {
            System.out.println(Thread.currentThread().getName() + ": Sell Car.");
            while (showroom.getCars().size() == 0) {
                System.out.println(Thread.currentThread().getName() + ": No Car in the showroom.");
                wait();
            }
            TimeUnit.SECONDS.sleep(SOLD_CAR);
            System.out.println(Thread.currentThread().getName() + ": Car sold");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return showroom.getCars().remove(0); // FIXME:

    }

    public synchronized void receiveCar() {
        System.out.println(Thread.currentThread().getName() + ": Accept the car");
        try {
            TimeUnit.SECONDS.sleep(ACCEPTANCE_OF_CAR);
            showroom.getCars().add(new Car());
            System.out.println(Thread.currentThread().getName() + ": Car acceptance completed.");
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
