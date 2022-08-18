package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindItemByNameActionTest {
    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("New item");
        tracker.add(item);
        FindItemByNameAction nam = new FindItemByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("New item");

        nam.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by name ====" + ln + item + ln));
        assertThat(tracker.findAll().get(0).getName(), is("New item"));
    }
}