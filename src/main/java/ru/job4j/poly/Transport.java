package ru.job4j.poly;

public interface Transport {
    void drive();

    void passengers(int countPassengers);

    int refuel(int countFuel);
}
