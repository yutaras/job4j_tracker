package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distance3d() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(2, 2, 2);
        double rsl = a.distance3d(b);
        double expected = 3.46;
        assertThat(rsl, closeTo(expected, 0.01));
    }
}