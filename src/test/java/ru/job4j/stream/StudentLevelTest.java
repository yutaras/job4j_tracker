package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Student1> input = new ArrayList<>();
        input.add(new Student1("Masha", 28));
        input.add(new Student1("Pety", 128));
        List<Student1> expected = List.of(
                new Student1("Pety", 128),
                new Student1("Masha", 28)
        );
        assertThat(StudentLevel.levelOf(input, 20), is(expected));
    }

    @Test
    public void whenOnlyNull() {
        List<Student1> input = new ArrayList<>();
        input.add(null);
        List<Student1> expected = List.of();
        assertThat(StudentLevel.levelOf(input, 100), is(expected));
    }

    @Test
    public void whenHasNull() {
        List<Student1> input = new ArrayList<>();
        input.add(null);
        input.add(new Student1("Pety", 28));
        List<Student1> expected = List.of(new Student1("Pety", 28));
        assertThat(StudentLevel.levelOf(input, 10), is(expected));
    }
}