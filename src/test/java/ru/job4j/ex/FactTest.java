package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenStartGreaterThenFinish() {
        Fact.calc(-1);
    }

    @Test
    public void when3() {
        int rsl = Fact.calc(3);
        assertThat(rsl, is(6));
    }
}