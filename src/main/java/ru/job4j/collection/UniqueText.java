package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = false;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        /* for-each origin -> new HashSet. */
        for (String word1 : origin) {
            check.add(word1);
        }
        /* for-each text -> hashSet.contains */
        for (String word2 : text) {
            if (check.contains(word2)) {
                rsl = true;
            }
                break;
        }
        return rsl;
    }
}
