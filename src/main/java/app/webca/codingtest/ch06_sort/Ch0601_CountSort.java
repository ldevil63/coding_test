package app.webca.codingtest.ch06_sort;

public class Ch0601_CountSort {
    
    public static void main(String[] args) {
        // 계수 정렬은 한정적인 상황에서 매우 빠르다.
        int[] array = { 7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2 };
        int[] count = new int[10];
        for (int n : array) {
            count[n]++;
        }
        for (int i = 0; i < count.length; i++) {
            // i 를 count[i] 만큼 출력
            for (int j = 0; j < count[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
