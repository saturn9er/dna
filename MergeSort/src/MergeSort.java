import java.util.Arrays;

/**
 * The class implements an elegant merge sort algorithm,
 * which is based on divide and conquer algorithm design
 * paradigm based on multi-branched recursion. This algorithm
 * divides input array of integers in halves, calls itself
 * for two halves and then merges the two sorted halves together.
 * This particular implementation uses top-down approach and
 * primitive int array (int[]).
 * @author Roman Romankov (saturn9er)
 */
public class MergeSort {

    /**
     * Sorts elements of two arrays in ascending order by comparing values in both arrays,
     * then concatenates them in a single array, and then return it.
     * @param left first (or left) array of integers (or part) to undergo sorting and merging
     * @param right last (or right) array of integers (or part) to undergo sorting and merging
     * @return a sorted array of integers
     */
    static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];

        // indices
        int l = 0;
        int r = 0;
        int m = 0;

        while (l < left.length || r < right.length) { // while either left OR right index still less than length of their array

            // if both, left AND right indices don't exceed their respective arrays' lengths
            // meaning both of them still have elements to consider
            if (l < left.length && r < right.length) {

                if (left[l] < right[r])
                    merged[m++] = left[l++];
                else
                    merged[m++] = right[r++];

            // if only left index doesn't exceed respective array's length
            // meaning that right array is empty
            } else if (l < left.length) {
                merged[m++] = left[l++];

            // if only right index doesn't exceed respective array's length
            // meaning that left array is empty
            } else if (r < right.length) {
                merged[m++] = right[r++];
            }
        }
        return merged;
    }

    /**
     * Recursively splits an array in halves then evokes merge() to do the sorting
     * and merging on splitted parts, then returns an array sorted in ascending order.
     * @param array unsorted array of integers
     * @return sorted array of integers
     */
    public static int[] sort(int[] array) {
        int length = array.length;
        int[] result = array;

        if (length > 1) {
            int median = array.length >> 1;
            int[] left = sort(Arrays.copyOfRange(array, 0, median));
            int[] right = sort(Arrays.copyOfRange(array, median, length));
            result = merge(left, right);
        }
        return result;
    }
}
