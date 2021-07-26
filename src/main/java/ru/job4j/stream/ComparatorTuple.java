package ru.job4j.stream;

import java.util.Comparator;

public class ComparatorTuple  implements Comparator<Tuple> {

    @Override
    public int compare(Tuple o1, Tuple o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
