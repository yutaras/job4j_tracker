package ru.job4j.tracker;

public class CreateActionRepeat implements UserAction {
    private final Output out;

    public CreateActionRepeat(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new ItemRepeat";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Create a new ItemRepeat ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        for (int i = 0; i < 1000; i++) {
            store.add(item);
        }
        return true;
    }
}
