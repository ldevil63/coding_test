package app.webca.codingtest.ch03_greedy;

/**
 * <pre>
 * 큰 수의 법칙
 * 
 * 1. 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙
 * 2. 특정 인덱스의 숫자를 연속으로 K번을 초과하여 더할 수 없다.
 * 3. 연속이 아니라면 K번 이상 더할 수 있다.
 * </pre>
 */
public class Ch0302_Greedy_fast {

    public static void main(String[] args) {
        int m = 8;
        int k = 3;
        int biggestNum = 0;
        int secondBiggestNum = 0;
        int[] inputNumArray = { 2, 4, 5, 4, 6 };

        // 첫번째와 두번째 큰 수 찾기 (sort 는 오바다...)
        for (int num : inputNumArray) {
            if (num > biggestNum) {
                secondBiggestNum = biggestNum;
                biggestNum = num;
            } else if (num > secondBiggestNum) {
                secondBiggestNum = num;
            }
        }

        // 계산
        int total = 0;
        while (m > 0) {
            if (m <= k) {
                total += m * biggestNum;
                m -= m;
            } else {
                total += k * biggestNum;
                total += secondBiggestNum;
                m -= k + 1;
            }
        }

        System.out.println("result : " + total);
    }
}
