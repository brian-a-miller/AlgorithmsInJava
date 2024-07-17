package dev.brianmiller.utils;

/**
 * @author Brian A. Miller
 */
public class MathUtils {

    private MathUtils() {
    }

    /**
     * Get a single digit from an integer
     *
     * Example:
     *
     * getDigit(position=0, value=4725, radix=10) returns 5
     * getDigit(position=1, value=4725, radix=10) returns 2
     * getDigit(position=2, value=4725, radix=10) returns 7
     * getDigit(position=3, value=4725, radix=10) returns 4
     *
     * @param position 0 for right-most
     * @param value input value to check
     * @param radix base of input value (10 for base 10 integer)
     * @return single digit of value at specified position
     */
    public static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }

    /**
     * Get a single digit from a long
     *
     * @param position 0 for right-most
     * @param value input value to check
     * @param radix base of input value (10 for base 10 integer)
     * @return single digit of value at specified position
     */
    public static long getDigit(int position, long value, int radix) {
        return value / (long) Math.pow(radix, position) % radix;
    }

}
