package ru.job4j.oop;

public class Dentist extends Doctor {
    private String characteristics;

    public Dentist() {
    }

    public Dentist(String name, String surname, String education,
                   int birthday, String specialisation, String characteristics) {
        super(name, surname, education, birthday, specialisation);
        this.characteristics = characteristics;
    }
}
