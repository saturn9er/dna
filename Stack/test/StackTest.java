import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.saturn9er.stack.Stack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class StackTest {

    Stack stack;

    @Before
    public void setUp() {
        stack = new Stack(3);
    }

    @After
    public void tearDown() {
        stack = null;
    }

    @Test
    public void testPushToEmpty() {
        assertTrue(stack.push(1));
        assertThat(stack.getSize(), equalTo(1));
    }

    @Test
    public void testPushToNonEmpty() {
        assertTrue(stack.push(1));
        assertTrue(stack.push(2));
        assertThat(stack.getSize(), equalTo(2));
    }

    @Test
    public void testPushToFull() {
        assertTrue(stack.push(1));
        assertTrue(stack.push(2));
        assertTrue(stack.push(3));
        assertFalse(stack.push(4));
        assertThat(stack.getSize(), equalTo(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void testPeekOnEmpty() {
        stack.peek();
    }

    @Test
    public void testPeek() {
        String object = "Pushed";
        stack.push(1);
        stack.push(object);
        assertThat(stack.peek(), equalTo(object));
    }



}
