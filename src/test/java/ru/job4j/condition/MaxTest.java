package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void when3numbers() {
        Max a = new Max();
        int result = a.max(1, 4, 2);
        int expected = 4;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void when4numbers() {
        Max a = new Max();
        int result = a.max(1, 4, 2, 7);
        int expected = 7;
        Assert.assertEquals(result, expected);
    }
}