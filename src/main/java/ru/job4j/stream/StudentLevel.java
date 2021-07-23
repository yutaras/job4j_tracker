package ru.job4j.stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLevel {
    public static List<Student1> levelOf(List<Student1> students, int bound) {
        return students.stream()
                .filter(st -> {
                    return Objects.nonNull(st);
                })
                .sorted((left, right) -> Integer.compare(right.getScore(), left.getScore()))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}
