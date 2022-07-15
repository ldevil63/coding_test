package app.webca.codingtest.ch07_search;

import app.webca.codingtest._common.Sorter;

/**
 * <pre>
 * 부품 찾기
 * 
 * 정수 형태의 고유한 번호가 있는 N개의 부품이 있다.
 * M개 종류의 부품 주문이 들어왔을 때 각 부품이 있는지 모두 확인하는 프로그램을 작성하라.
 * 있으면 yes, 없으면 no
 * </pre>
 */
public class Ch0702 {

    private static int bsearch(Integer[] array, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middle = (start + end) / 2;
        if (array[middle] < target) {
            return bsearch(array, target, middle + 1, end);
        } else if (target < array[middle]) {
            return bsearch(array, target, start, middle - 1);
        } else {
            return middle;
        }
    }
    
    public static void main(String[] args) {
        Integer[] n = { 8, 3, 7, 9, 2 };
        Integer[] m = { 5, 7, 9 };

        Sorter.asc(n);
        for (Integer i : m) {
            if (bsearch(n, i, 0, n.length) >= 0) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}
