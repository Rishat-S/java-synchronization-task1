package ru.netology;

public class Main {

    public static void main(String[] args) {
       Showroom showroom = new Showroom();

       new Thread(showroom::sellCar, "Customer").start();

       new Thread(showroom::acceptCar, "Manufacturer").start();
    }
}
