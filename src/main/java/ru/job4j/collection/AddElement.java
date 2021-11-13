package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class AddElement {
    public static boolean addNewElement(List<String> list, String str) {
        boolean rsl = false;
        List<String> check = new ArrayList<>(list);
        check.add(str);
        if (check.size() != list.size()) {
            rsl = true;
        }
        return rsl;
    }
}
