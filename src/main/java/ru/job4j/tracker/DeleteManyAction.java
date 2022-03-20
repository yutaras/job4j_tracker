package ru.job4j.tracker;

public class DeleteManyAction implements UserAction {
    private final Output out;

    public DeleteManyAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Many Items";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Delete items ====");
        int id = input.askInt("Enter id: ");
        while (store.delete(id)) {
            out.println("Заявка удалена успешно.");
        }
        return true;
    }
}
