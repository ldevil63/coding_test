package app.webca.codingtest.ch06_sort;

import java.util.Arrays;

import app.webca.codingtest._common.Sorter;

/**
 * <pre>
 * 두  배열의 원소 교체
 * 
 * A 와 B 의 값을 최대 K번 교체하여 A 의 값이 최대가 되도록 만들어라.
 * </pre>
 */
public class Ch0604 {
    
    public static void main(String[] args) {
        Integer[] a = { 1, 2, 5, 4, 3 };
        Integer[] b = { 5, 5, 6, 6, 5 };
        int k = 3;

        Sorter.asc(a);
        Sorter.desc(b);

        for (int i = 0; i < k; i++) {
            if (a[i] < b[i]) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            } else {
                break;
            }
        }

        Integer sum = Arrays.stream(a).reduce(0, Integer::sum);
        System.out.println("sum : " + sum);
    }
}
