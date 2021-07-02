package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Reboot server", 1),
                new Job("Reboot server", 4)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobByName().thenComparing(new JobByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Reboot server", 1),
                new Job("Reboot server", 4)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void jobByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Reboot server", 1),
                new Job("Fix bugs", 4),
                new Job("Impl task", 2)
        );
        List<Job> expected = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        Collections.sort(jobs, new JobByName());
        assertThat(jobs, is(expected));
    }

    @Test
    public void jobDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Reboot server", 1),
                new Job("Fix bugs", 4),
                new Job("Impl task", 2)
        );
        List<Job> expected = Arrays.asList(
                new Job("Reboot server", 1),
                new Job("Impl task", 2),
                new Job("Fix bugs", 4)
        );
        Collections.sort(jobs, new JobDescByName());
        assertThat(jobs, is(expected));
    }

    @Test
    public void jobByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Reboot server", 1),
                new Job("Fix bugs", 4),
                new Job("Impl task", 2)
        );
        List<Job> expected = Arrays.asList(
                new Job("Reboot server", 1),
                new Job("Impl task", 2),
                new Job("Fix bugs", 4)
        );
        Collections.sort(jobs, new JobByPriority());
        assertThat(jobs, is(expected));
    }

    @Test
    public void jobDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Reboot server", 1),
                new Job("Fix bugs", 4),
                new Job("Impl task", 2)
        );
        List<Job> expected = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        Collections.sort(jobs, new JobDescByPriority());
        assertThat(jobs, is(expected));
    }
}