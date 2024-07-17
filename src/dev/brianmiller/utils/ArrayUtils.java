package dev.brianmiller.utils;

/**
 * @author Brian A. Miller
 */
public class ArrayUtils {

    private ArrayUtils() {
    }

    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.println(" ]");
    }
}
