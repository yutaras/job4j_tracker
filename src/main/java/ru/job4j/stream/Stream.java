package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(6);
        arr.add(-2);
        arr.add(1);
        arr.add(2);
        arr.add(-8);
        List<Integer> counts = arr.stream().filter(
                element -> element > 0
        ).collect(Collectors.toList());
        counts.forEach(System.out::println);
    }
}
