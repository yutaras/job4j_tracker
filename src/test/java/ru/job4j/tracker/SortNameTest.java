package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortNameTest {
    @Test
    public void compare() {
        List<Item> items = Arrays.asList(
                new Item(5, "Бублик"),
                new Item(2, "Ватрушка"),
                new Item(4, "Ананас")
        );
        List<Item> expected = Arrays.asList(
                new Item(4, "Ананас"),
                new Item(5, "Бублик"),
                new Item(2, "Ватрушка")
        );
        Collections.sort(items, new SortName());
        assertThat(items, is(expected));
    }
}