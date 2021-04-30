package ru.job4j.oop;

public class Doctor extends Profession {
    private String specialisation;

    public Doctor() {
    }

    public Doctor(String name, String surname, String education, int birthday, String specialisation) {
        super(name, surname, education, birthday);
        this.specialisation = specialisation;
    }
}
