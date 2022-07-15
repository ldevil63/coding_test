package app.webca.codingtest.ch07_search;

import app.webca.codingtest._common.NumberUtil;

/**
 * <pre>
 * 떡볶이 떡 만들기
 * 
 * 길이가 일정하지 않은 N개의 떡이 있고, 이를 절단기로 잘라서 자른 부분을 팔 수 있다..
 * 손님이 M 만큼의 떡을 사려는 경우, 절단기에 설정할 수 있는 최대 높이를 구하라.
 * </pre>
 */
public class Ch0703 {

    private static int cut(int[] array, int h) {
        int sum = 0;
        for (int dd : array) {
            if (dd > h) {
                sum += dd - h;
            }
        }
        return sum;
    }

    private static int find(int[] array, int m) {
        int start = 0;
        int end = NumberUtil.max(array);
        int result = 0;

        while (start <= end) {
            int middle = (start + end) / 2;
            int cut = cut(array, middle);
            if (cut < m) {
                end = middle - 1;
            } else {
                result = middle;
                start = middle + 1;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int m = 6;

        int[] array = { 19, 15, 10, 17 };

        System.out.println("result : " + find(array, m));
    }
}
