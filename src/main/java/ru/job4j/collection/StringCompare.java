package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int count = Integer.compare(left.length(), right.length());
        if ((count == 0) || (left.length() < right.length())) {
            for (int i = 0; i < left.length(); i++) {
                int rsl = Character.compare(left.charAt(i), right.charAt(i));
                count += rsl;
            }
        } else if (right.length() < left.length()) {
            for (int i = 0; i < right.length(); i++) {
                int rsl = Character.compare(left.charAt(i), right.charAt(i));
                count += rsl;
            }
        }
        return count;
    }
}
