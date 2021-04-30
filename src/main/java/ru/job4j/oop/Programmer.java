package ru.job4j.oop;

public class Programmer extends Engineer {
    private String programmingLanguage;

    public Programmer() {
    }

    public Programmer(String name, String surname, String education, int birthday, String accuracy, int speed, String programmingLanguage) {
        super(name, surname, education, birthday, accuracy, speed);
        this.programmingLanguage = programmingLanguage;
    }
}
