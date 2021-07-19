package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void listOfAddressSortCityAndDeleteDuplicates() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Moskow", "Lenina", 33, 1)),
                new Profile(new Address("Moskow", "Lenina", 33, 1)),
                new Profile(new Address("London", "Trafalgar", 22, 3)),
                new Profile(new Address("Vladimir", "Urickogo", 115, 2)),
                new Profile(new Address("London", "Trafalgar", 22, 3))
        );

        Profiles pr = new Profiles();
        List<Address> rsl = pr.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("London", "Trafalgar", 22, 3));
        expected.add(new Address("Moskow", "Lenina", 33, 1));
        expected.add(new Address("Vladimir", "Urickogo", 115, 2));
        assertThat(rsl, is(expected));
    }
}