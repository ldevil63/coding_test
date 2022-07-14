package app.webca.codingtest.ch06_sort;

import app.webca.codingtest._common.Sorter;

/**
 * <pre>
 * 위에서 아래로
 * 
 * 입력받은 숫자를 정렬하는 것으로, 너무 단순하니 정렬 기능 사용
 * </pre>
 */
public class Ch0602 {

    public static void main(String[] args) {
        Integer[] array = { 15, 27, 12 };
        Sorter.desc(array);
        for (int n : array) {
            System.out.print(n + " ");
        }
    }
    
}
