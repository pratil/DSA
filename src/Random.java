public class Random {
    private static final int DEFAULT_DOUBLE = 100;
    private static final int DEFAULT_INTEGER = 100;
    private static final int DEFAULT_STRING_LENGTH = 5;
    private static final String ALL_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int ALL_CHARS_LENGTH = ALL_CHARS.length();

    public static double doubleValue(int from, int till) {
        return Math.random() * (till - from) + from;
    }

    public static double doubleValue(int till) {
        return doubleValue(0, till);
    }

    public static double doubleValue() {
        return doubleValue(DEFAULT_DOUBLE);
    }

    public static int intValue(int from, int till) {
        return (int) (Math.random() * (till - from)) + from;
    }

    public static int intValue(int till) {
        return intValue(0, till);
    }

    public static int intValue() {
        return intValue(DEFAULT_INTEGER);
    }

    public static String string(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++)
            stringBuilder.append(ALL_CHARS.charAt(intValue(ALL_CHARS_LENGTH)));
        return stringBuilder.toString();
    }

    public static String string() {
        return string(DEFAULT_STRING_LENGTH);
    }

}
