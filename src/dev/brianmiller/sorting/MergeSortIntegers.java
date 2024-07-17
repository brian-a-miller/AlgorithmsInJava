package dev.brianmiller.sorting;

import dev.brianmiller.utils.ArrayUtils;

/**
 * Example of merge sort implementation with option to specify
 * ASCENDING or DESCENDING sort order
 *
 * @author Brian A. Miller
 * @email
 */
public class MergeSortIntegers {

    public enum SortOrder {
        ASCENDING,
        DESCENDING
    }

    public static void main(String[] args) {

        //
        // Sample test data
        //
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        System.out.println("Before sorting:");
        ArrayUtils.printArray(intArray);

        mergeSort(intArray, SortOrder.DESCENDING, 0, intArray.length);

        System.out.println("After sorting in DESCENDING order:");
        ArrayUtils.printArray(intArray);
    }

    /**
     * Sort integer array in place
     *
     * @param data integer array, initially unsorted, will be modified by sort
     * @param sortOrder either ascending or descending order
     * @param start first index, inclusive, when sorting
     * @param end last index, EXCLUSIVE; use length of array for sorting whole array
     */
    public static void mergeSort(int[] data, SortOrder sortOrder,
                                 int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(data, sortOrder, start, mid);
        mergeSort(data, sortOrder, mid, end);
        merge(data, sortOrder, start, mid, end);
    }

    public static void merge(int[] input, SortOrder sortOrder,
                             int start, int mid, int end) {

        if (SortOrder.ASCENDING.equals(sortOrder) && (input[mid - 1] <= input[mid])) {
            return;
        } else if (SortOrder.DESCENDING.equals(sortOrder) && (input[mid - 1] >= input[mid])) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            if (SortOrder.ASCENDING.equals(sortOrder)) {
                temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
            } else {
                temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
            }
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}
