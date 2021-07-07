package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split("/");
        String[] second = o2.split("/");
        int rsl;
        rsl = second[0].compareTo(first[0]);
        if (rsl == 0) {
            rsl = o1.compareTo(o2);
        }
            return rsl;
        }
    }
