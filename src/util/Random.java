package util;

// a class to generate the random data for testing purpose
public class Random {

    // default values for max and min ranges for different numbers
    private static final int DEFAULT_DOUBLE_MIN_RANGE = 0;
    private static final int DEFAULT_DOUBLE_MAX_RANGE = 100;
    private static final int DEFAULT_INTEGER_MIN_RANGE = 0;
    private static final int DEFAULT_INTEGER_MAX_RANGE = 100;
    private static final int DEFAULT_STRING_LENGTH = 5; // default values for string length
    // all the characters from which it'll generate a random string
    private static final String ALL_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int ALL_CHARS_LENGTH = ALL_CHARACTERS.length();

    // to generate a random double value in a given range [from, till]
    public static double doubleValue(int from, int till) {
        return Math.random() * (till - from) + from;
    }

    // to generate a random double value in a given range [DEFAULT_DOUBLE_MIN_RANGE, till]
    public static double doubleValue(int till) {
        return doubleValue(DEFAULT_DOUBLE_MIN_RANGE, till);
    }

    // to generate a random double value in a given range [DEFAULT_DOUBLE_MIN_RANGE, DEFAULT_DOUBLE_MAX_RANGE]
    public static double doubleValue() {
        return doubleValue(DEFAULT_DOUBLE_MAX_RANGE);
    }

    // to generate a random integer value in a given range [from, till]
    public static int intValue(int from, int till) {
        return (int) (Math.random() * (till - from)) + from;
    }

    // to generate a random integer value in a given range [DEFAULT_INTEGER_MIN_RANGE, till]
    public static int intValue(int till) {
        return intValue(DEFAULT_INTEGER_MIN_RANGE, till);
    }

    // to generate a random integer value in a given range [DEFAULT_INTEGER_MIN_RANGE, DEFAULT_INTEGER_MAX_RANGE]
    public static int intValue() {
        return intValue(DEFAULT_INTEGER_MAX_RANGE);
    }

    // to generate a random String value of given Length
    public static String string(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++)
            stringBuilder.append(ALL_CHARACTERS.charAt(intValue(ALL_CHARS_LENGTH)));
        return stringBuilder.toString();
    }

    // to generate a random String value of DEFAULT_STRING_LENGTH
    public static String string() {
        return string(DEFAULT_STRING_LENGTH);
    }

}
