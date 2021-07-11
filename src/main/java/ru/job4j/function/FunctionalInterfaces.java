package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (s, s1) -> map.put(s, s1);
        biCon.accept(1, "one");
        biCon.accept(2, "two");
        biCon.accept(3, "three");
        biCon.accept(4, "four");
        biCon.accept(5, "five");
        biCon.accept(6, "six");
        biCon.accept(7, "seven");
        System.out.println(map);
        BiPredicate<Integer, String> biPred = (integer, s) -> integer % 2 == 0 || s.length() == 4;
        for (Integer i : map.keySet()) {
            if (biPred.test(4, "three")) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }
        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        Consumer<List<String>> con = (s) -> System.out.println(s);
        con.accept(sup.get());
        Function<String, String> func = s -> s.toUpperCase();
        System.out.println(func.apply("second"));
    }
}
