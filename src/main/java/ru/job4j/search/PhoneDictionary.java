package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    /*public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person value : persons) {
            if (value.getName().contains(key) || value.getSurname().contains(key)
                    || value.getPhone().contains(key) || value.getAddress().contains(key)) {
                result.add(value);
                System.out.println(value);
            } else {
                System.out.println("Пользователь не найден");
            }
        }
            return result;
        }*/
    public ArrayList<Person> find(String key) {
        Predicate<Person> pr1 = value -> value.getName().contains(key);
        Predicate<Person> pr2 = value -> value.getSurname().contains(key);
        Predicate<Person> pr3 = value -> value.getPhone().contains(key);
        Predicate<Person> pr4 = value -> value.getAddress().contains(key);
        Predicate<Person> combine = pr1.or(pr2).or(pr3).or(pr4);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Ivanov", "534879", "Moskva")
        );
        phones.find("Ivan");
    }
}
