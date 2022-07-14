package app.webca.codingtest.ch03_greedy;

import java.util.Arrays;
import java.util.Collections;

import app.webca.codingtest._common.Converter;

/**
 * <pre>
 * 큰 수의 법칙
 * 
 * 1. 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙
 * 2. 특정 인덱스의 숫자를 연속으로 K번을 초과하여 더할 수 없다.
 * 3. 연속이 아니라면 K번 이상 더할 수 있다.
 * </pre>
 */
public class Ch0302_Greedy_sort {

    public static void main(String[] args) {
        int m = 8;
        int k = 3;
        int biggestNum = 0;
        int secondBiggestNum = 0;
        int[] inputNumArray = { 2, 4, 5, 4, 6 };

        // 첫번째와 두번째 큰 수 찾기 (sort 이용)
        // 내림차순 정렬에 사용하기 위해 Integer[] 로 변환 필요
        Integer[] numArray = Converter.toBoxedArray(inputNumArray);
        Arrays.sort(numArray, Collections.reverseOrder());
        biggestNum = numArray[0];
        secondBiggestNum = numArray[1];

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
