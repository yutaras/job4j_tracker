package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortNameDecreaseTest {

    @Test
    public void compareDecrease() {
        List<Item> items = Arrays.asList(
                new Item(5, "Бублик"),
                new Item(2, "Ватрушка"),
                new Item(4, "Ананас")
        );
        Collections.sort(items, new SortNameDecrease());
        assertThat(items.get(0).getName(), is("Ватрушка"));
    }
}