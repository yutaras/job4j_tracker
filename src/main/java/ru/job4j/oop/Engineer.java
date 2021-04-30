package ru.job4j.oop;

public class Engineer extends Profession {
    private String accuracy;
    private int speed;

    public Engineer() {
    }

    public Engineer(String name, String surname, String education, int birthday, String accuracy, int speed) {
        super(name, surname, education, birthday);
        this.accuracy = accuracy;
        this.speed = speed;
    }
}

