package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Integer.parseInt;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] arrayLeft = left.split("\\.");
        String[] arrayRight = right.split("\\.");
        int one = parseInt(arrayLeft[0]);
        int two = parseInt(arrayRight[0]);
        return Integer.compare(one, two);
    }
}
