import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class MergeSortTest {

    @Test
    public void testMergeSingles() {
        Comparable[] actual = MergeSort.merge(new Comparable[]{3}, new Comparable[]{8});
        Comparable[] expected = {3, 8};

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void testMergeMultiples() {
        Comparable[] actual = MergeSort.merge(new Comparable[]{3, 4, 6}, new Comparable[]{8, 10, 42, 88});
        Comparable[] expected = {3, 4, 6, 8, 10, 42, 88};

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void testSortIntegers() {
        Comparable[] actual = MergeSort.sort(new Comparable[]{4, 1, 6, 2, 0, 41, 23, 92, -22});
        Comparable[] expected = {-22, 0, 1, 2, 4, 6, 23, 41, 92};

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void testSortDoubles() {
        Comparable[] actual = MergeSort.sort(new Comparable[]{3.32, 0.1, 45.11345, 3.33, -10.2301, 0.000001});
        Comparable[] expected = {-10.2301, 0.000001, 0.1, 3.32, 3.33, 45.11345};

        assertThat(actual, equalTo(expected));
    }

}
