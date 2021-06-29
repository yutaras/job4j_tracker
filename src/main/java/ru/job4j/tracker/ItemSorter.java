package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemSorter {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(5, "Юра"),
                new Item(2, "Привет"),
                new Item(4, "это")
        );
        System.out.println(items);
        Collections.sort(items);
        System.out.println(items);
        Collections.sort(items, new SortName());
        System.out.println(items);
    }
}
