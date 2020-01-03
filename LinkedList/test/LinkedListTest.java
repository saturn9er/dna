import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.saturn9er.linkedlist.LinkedList;
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
        assertThat(list.getSize(), equalTo(0));
    }

    @Test
    public void testIsEmptyWithNonEmptyList() {
        list.append(1);

        assertFalse(list.isEmpty());
        assertThat(list.getSize(), equalTo(1));
    }

    @Test
    public void testAppendToEmptyList() {
        LinkedList.Node<Integer> node = list.append(1);

        assertThat(list.getHead(), equalTo(node));
        assertThat(list.getTail(), equalTo(node));
        assertThat(list.getSize(), equalTo(1));
    }

    @Test
    public void testAppendToNonEmptyList() {
        list.append(1);
        list.append(2);
        LinkedList.Node<Integer> node = list.append(3);

        assertThat(list.getTail(), equalTo(node));
        assertThat(list.getSize(), equalTo(3));
    }

    @Test
    public void testPrependToEmptyList() {
        LinkedList.Node<Integer> node = list.prepend(1);

        assertThat(list.getHead(), equalTo(node));
        assertThat(list.getTail(), equalTo(node));
        assertThat(list.getSize(), equalTo(1));
    }

    @Test
    public void testPrependToNonEmptyList() {
        list.append(1);
        list.append(2);
        LinkedList.Node<Integer> node = list.prepend(3);

        assertThat(list.getHead(), equalTo(node));
        assertThat(list.getSize(), equalTo(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetHeadFromEmptyList() {
        list.getHead();
    }

    @Test
    public void testGetHead() {
        list.append(1);
        LinkedList.Node<Integer> node = list.prepend(2);

        assertThat(node, equalTo(list.getHead()));
    }

    @Test(expected = NoSuchElementException.class)
    public void testGeTailFromEmptyList() {
        list.getTail();
    }

    @Test
    public void testGetTail() {
        list.append(1);
        LinkedList.Node<Integer> node = list.append(2);

        assertThat(node, equalTo(list.getTail()));
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetNonExistingElement() {
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

        assertThat(list.get(list.getSize() - 1), equalTo(node));
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
        assertThat(toBeRemoved.getValue(), equalTo(null));
        assertThat(toBeRemoved.getNext(), equalTo(null));
        assertThat(toBeRemoved.getPrevious(), equalTo(null));
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFromListWithSingleElement() {
        list.append(1);

        assertTrue(list.remove(0));

        list.get(0); // NoSuchElementException expected

        assertThat(list.getSize(), equalTo(0));
    }

    @Test
    public void testRemoveHead() {
        list.append(1);
        LinkedList.Node<Integer> headToBe = list.append(2);
        list.append(3);

        assertTrue(list.remove(0));
        assertThat(list.getHead(), equalTo(headToBe));
        assertThat(list.getSize(), equalTo(2));
    }

    @Test
    public void testRemoveTail() {
        list.append(1);
        LinkedList.Node<Integer> tailToBe = list.append(2);
        list.append(3);

        assertTrue(list.remove(list.getSize() - 1));
        assertThat(list.getTail(), equalTo(tailToBe));
        assertThat(list.getSize(), equalTo(2));
    }

}
