import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class LinkedListTest {

    LinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new LinkedList<Integer>();
    }

    @After
    public void tearDown() {
        list = null;
    }

    @Test
    public void testIsEmptyWithNewList() {
        assertTrue(list.isEmpty());
        assertThat(list.size, equalTo(0));
    }

    @Test
    public void testIsEmptyWithNonEmptyList() {
        list.append(1);

        assertFalse(list.isEmpty());
        assertThat(list.size, equalTo(1));
    }

    @Test
    public void testAppendToEmptyList() {
        LinkedList.Node<Integer> node = list.append(1);

        assertThat(list.head, equalTo(node));
        assertThat(list.tail, equalTo(node));
        assertThat(list.size, equalTo(1));
    }

    @Test
    public void testAppendToNonEmptyList() {
        list.append(1);
        list.append(2);
        LinkedList.Node<Integer> node = list.append(3);

        assertThat(list.tail, equalTo(node));
        assertThat(list.size, equalTo(3));
    }

    @Test
    public void testPrependToEmptyList() {
        LinkedList.Node<Integer> node = list.prepend(1);

        assertThat(list.head, equalTo(node));
        assertThat(list.tail, equalTo(node));
        assertThat(list.size, equalTo(1));
    }

    @Test
    public void testPrependToNonEmptyList() {
        list.append(1);
        list.append(2);
        LinkedList.Node<Integer> node = list.prepend(3);

        assertThat(list.head, equalTo(node));
        assertThat(list.size, equalTo(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetFirstValueFromEmptyList() {
        list.getFirstValue();
    }

    @Test
    public void testGetFirstValue() {
        list.append(1);
        LinkedList.Node<Integer> node = list.prepend(2);

        assertThat(node.value, equalTo(list.getFirstValue()));
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetLastValueFromEmptyList() {
        list.getLastValue();
    }

    @Test
    public void testGetLastValue() {
        list.append(1);
        LinkedList.Node<Integer> node = list.append(2);

        assertThat(node.value, equalTo(list.getLastValue()));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetElementWithIndexOutOfBounds() {
        list.get(0);
    }

    @Test
    public void testGetElementWithIndexWithinBounds() {
        list.append(1);
        list.append(2);
        LinkedList.Node<Integer> node = list.append(3);

        assertThat(list.get(2), equalTo(node));
    }

    @Test
    public void testGetFirstIndexElement() {
        LinkedList.Node<Integer> node = list.append(1);
        list.append(2);
        list.append(3);

        assertThat(list.get(0), equalTo(node));
    }

    @Test
    public void testGetLastIndexElement() {
        list.append(1);
        list.append(2);
        LinkedList.Node<Integer> node = list.append(3);

        assertThat(list.get(list.size - 1), equalTo(node));
    }

    @Test
    public void testRemoveFromEmptyList() {
        assertFalse(list.remove(0) );
    }

    @Test
    public void testRemove() {
        list.append(1);
        list.append(2);
        LinkedList.Node<Integer> toBeRemoved = list.append(3);
        LinkedList.Node<Integer> toBeTheThird = list.append(4);
        list.append(5);

        assertTrue(list.remove(2));
        assertThat(list.get(2), equalTo(toBeTheThird));
        assertThat(toBeRemoved.value, equalTo(null));
        assertThat(toBeRemoved.next, equalTo(null));
        assertThat(toBeRemoved.previous, equalTo(null));
    }

    @Test
    public void testRemoveFromListWithSingleElement() {
        list.append(1);

        assertTrue(list.remove(0));
        assertThat(list.head, equalTo(null));
        assertThat(list.tail, equalTo(null));
        assertThat(list.size, equalTo(0));
    }

    @Test
    public void testRemoveHead() {
        list.append(1);
        LinkedList.Node<Integer> headToBe = list.append(2);
        list.append(3);

        assertTrue(list.remove(0));
        assertThat(list.head, equalTo(headToBe));
        assertThat(list.size, equalTo(2));
    }

    @Test
    public void testRemoveTail() {
        list.append(1);
        LinkedList.Node<Integer> tailToBe = list.append(2);
        list.append(3);

        assertTrue(list.remove(list.size - 1));
        assertThat(list.tail, equalTo(tailToBe));
        assertThat(list.size, equalTo(2));
    }

}
