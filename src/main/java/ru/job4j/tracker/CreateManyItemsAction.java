package ru.job4j.tracker;

public class CreateManyItemsAction implements UserAction {
    private final Output out;

    public CreateManyItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add many Items with same name";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Create many Items with same name ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        for (int i = 0; i < 1000; i++) {
            store.add(item);
        }
        return true;
    }
}
