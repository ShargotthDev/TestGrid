package shargotth.be.testgrid;

import java.util.Random;

//Class derived from https://github.com/Trinea/android-common/blob/master/src/cn/trinea/android/common/util/RandomUtils.java
public class RandomUtils {

    public static final String NUMBERS_AND_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private RandomUtils() {
        throw new AssertionError();
    }

    /**
     * get a fixed-length random string, its a mixture of uppercase, lowercase letters and numbers
     *
     * @param length
     * @return
     * @see RandomUtils#getRandom(String source, int length)
     */
    public static String getRandomNumbersAndLetters(int length) {
        return getRandom(NUMBERS_AND_LETTERS, length);
    }

    /**
     * get a fixed-length random string, its a mixture of chars in source
     *
     * @param source
     * @param length
     * @return <ul>
     *         <li>if source is null or empty, return null</li>
     *         <li>else see {@link RandomUtils#getRandom(char[] sourceChar, int length)}</li>
     *         </ul>
     */
    public static String getRandom(String source, int length) {
        return source == null || source.isEmpty() ? null : getRandom(source.toCharArray(), length);
    }

    /**
     * get a fixed-length random string, its a mixture of chars in sourceChar
     *
     * @param sourceChar
     * @param length
     * @return <ul>
     *         <li>if sourceChar is null or empty, return null</li>
     *         <li>if length less than 0, return null</li>
     *         </ul>
     */
    public static String getRandom(char[] sourceChar, int length) {
        if (sourceChar == null || sourceChar.length == 0 || length < 0) {
            return null;
        }

        StringBuilder str = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            str.append(sourceChar[random.nextInt(sourceChar.length)]);
        }
        return str.toString();
    }

    /**
     * get random int between min and max
     *
     * @param min
     * @param max
     * @return <ul>
     *         <li>if min > max, return 0</li>
     *         <li>if min == max, return min</li>
     *         <li>else return random int between min and max</li>
     *         </ul>
     */
    public static int getRandom(int min, int max) {
        if (min > max) {
            return 0;
        }
        if (min == max) {
            return min;
        }
        return min + new Random().nextInt(max - min);
    }
}
