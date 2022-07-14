package app.webca.codingtest._common;

public class NumberUtil {

    public static int min(int[] array) {
        int minNum = Integer.MAX_VALUE;
        for (int num : array) {
            minNum = Math.min(num, minNum);
        }
        return minNum;
    }

    public static int max(int[] array) {
        int maxNum = Integer.MIN_VALUE;
        for (int num : array) {
            maxNum = Math.max(num, maxNum);
        }
        return maxNum;
    }
}
