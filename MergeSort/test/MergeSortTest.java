import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class MergeSortTest {

    @Test
    public void testMergeSingles() {
        int[] actual = MergeSort.merge(new int[]{3}, new int[]{8});
        int[] expected = {3, 8};

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void testMergeMultiples() {
        int[] actual = MergeSort.merge(new int[]{3, 4, 6}, new int[]{8, 10, 42, 88});
        int[] expected = {3, 4, 6, 8, 10, 42, 88};

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void testSort() {
        int[] actual = MergeSort.sort(new int[]{4, 1, 6, 2, 0, 41, 23, 92, -22});
        int[] expected = {-22, 0, 1, 2, 4, 6, 23, 41, 92};

        assertThat(actual, equalTo(expected));
    }

}
