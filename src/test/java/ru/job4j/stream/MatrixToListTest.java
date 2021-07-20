package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void convert() {
        Integer[][] matrix = {
                {3, 22, 9},
                {11, 55}
        };
        MatrixToList mtx = new MatrixToList();
        List<Integer> rsl = mtx.convert(matrix);
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(22);
        expected.add(9);
        expected.add(11);
        expected.add(55);
        assertThat(rsl, is(expected));
    }
}