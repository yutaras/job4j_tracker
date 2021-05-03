package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иванов Иван Иванович");
        student.setGroup("Радиэлектроника");
        student.setAdmissionDate(new Date());

        System.out.println(student.getFullName()
                + " поступил на факультет - "
                + student.getGroup()
                + " : " + student.getAdmissionDate());
    }
}
