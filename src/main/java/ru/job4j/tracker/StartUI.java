package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        Item item2 = new Item();
        item1.setName("Заявление");
        item1.setId(1);
        item2.setName("Книга");
        item2.setId(2);
        tracker.add(item1);
        tracker.add(item2);
        System.out.println(tracker.findById(1));
        System.out.println(tracker.findById(2));
    }
}
