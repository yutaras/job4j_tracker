package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Сказки Пушкина", 99);
        Book book2 = new Book("Евгений Онегин", 100);
        Book book3 = new Book("Clean code", 59);
        Book book4 = new Book("Мцыри", 44);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            System.out.println(pr.getName() + " - " + pr.getNumberOfPages());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("После перестановки: ");
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            System.out.println(pr.getName() + " - " + pr.getNumberOfPages());
        }
        System.out.println("Выводом книг с именем \"Clean code\":");
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            if (pr.getName().equals("Clean code")) {
                System.out.println(pr.getName() + " - " + pr.getNumberOfPages());
            }
        }
    }
}
