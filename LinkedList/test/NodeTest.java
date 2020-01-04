import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.saturn9er.linkedlist.LinkedList;
import org.junit.Test;

public class NodeTest {

    @Test
    public void testNewNode() {
        LinkedList.Node<String> node = new LinkedList.Node<String>("saturn9er", null, null);

        assertThat(node.getValue(), equalTo("saturn9er"));
        assertThat(node.getPrevious(), equalTo(null));
        assertThat(node.getNext(), equalTo(null));
    }

    @Test
    public void testHasPrevious() {
        LinkedList.Node<Boolean> nodeA = new LinkedList.Node<Boolean>(true, null, null);
        LinkedList.Node<Boolean> nodeB = new LinkedList.Node<Boolean>(false, nodeA, null);

        assertFalse(nodeA.hasPrevious());
        assertTrue(nodeB.hasPrevious());
    }

    @Test
    public void testHasNext() {
        LinkedList.Node<Boolean> nodeB = new LinkedList.Node<Boolean>(true, null, null);
        LinkedList.Node<Boolean> nodeA = new LinkedList.Node<Boolean>(false, null, nodeB);

        assertTrue(nodeA.hasNext());
        assertFalse(nodeB.hasNext());
    }

}
