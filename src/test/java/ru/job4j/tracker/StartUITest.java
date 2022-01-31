package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        MemTracker tracker = new MemTracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitProgramAction()
        };
        new StartUI(output).init(in, tracker, Arrays.asList(actions));
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitProgramAction()
        };
        new StartUI(output).init(in, tracker, Arrays.asList(actions));
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitProgramAction()
        };
        new StartUI(output).init(in, tracker, Arrays.asList(actions));
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        MemTracker tracker = new MemTracker();
        UserAction[] actions = {
                new ExitProgramAction()
        };
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() + "0. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAll() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("item1"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = {
                new FindAllAction(output),
                new ExitProgramAction()
        };
        new StartUI(output).init(in, tracker, Arrays.asList(actions));
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Show all items ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindItemById() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("item1"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindItemByIdAction(output),
                new ExitProgramAction()
        };
        new StartUI(output).init(in, tracker, Arrays.asList(actions));
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Find item by id ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindItemByName() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("item1"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[]{"0", "item1", "1"}
        );
        UserAction[] actions = {
                new FindItemByNameAction(output),
                new ExitProgramAction()
        };
        new StartUI(output).init(in, tracker, Arrays.asList(actions));
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find item by name" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Find item by name ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find item by name" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"7", "0"}
        );
        MemTracker tracker = new MemTracker();
        UserAction[] actions = new UserAction[]{
                new ExitProgramAction()
        };
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit Program" + ln
                )
        );
    }

    @Test
    public void init() {
    }
}