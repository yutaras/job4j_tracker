package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        /* цикл fori, поскольку нам надо найти индекс искомого элемента в массиве */
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                return i;
            }
        }
        throw new ElementNotFoundException("Element not found");
    }

    public static void main(String[] args) {
        String[] array = new String[]{"привет", "да", "пока", "до свидания"};
        try {
            System.out.println(indexOf(array, "пока"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
