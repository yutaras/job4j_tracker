package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== List of all items ====");
                Item[] arr = tracker.findAll();
                for (Item item : arr) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Enter the ID of the required item: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter a new name for the item: ");
                String name = scanner.nextLine();
                Item newItem = new Item(name);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Successfully completed");
                } else {
                    System.out.println("Error. Check the correctness of the entered values");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter the ID of the deleted item: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Successfully completed");
                } else {
                    System.out.println("Error. Check the correctness of the entered values");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Enter the ID of the item: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item rsl = tracker.findById(id);
                if (rsl != null) {
                    System.out.println(rsl);
                } else {
                    System.out.println("Error. Item with the ID not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.print("Enter the name of the item: ");
                String name = scanner.nextLine();
                Item[] rsl = tracker.findByName(name);
                if (rsl.length > 0) {
                    for (Item item : rsl) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Error. Item with the name not found");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
