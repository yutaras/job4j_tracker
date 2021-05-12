package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {

    }

    @Override
    public void passengers(int countPassengers) {

    }

    @Override
    public int refuel(int countFuel) {
        return countFuel * 45; // количество топлива * цену
    }
}
