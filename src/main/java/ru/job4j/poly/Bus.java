package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Водить");
    }

    @Override
    public void passengers(int countPassengers) {
        System.out.println("Количетво пассажиров");
    }

    @Override
    public int refuel(int countFuel) {
        return countFuel * 45; // количество топлива * цену
    }
}
