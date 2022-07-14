package app.webca.codingtest.ch06_sort;

public class Ch0601_SelectionSort {

    private static void print(int[] array) {
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };
        
        // 선택 정렬 : 가장 작은 값을 선택해서 앞에서부터 채워 나간다.
        // 속도 : O(N^2)
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
            print(array);
        }
    }
    
}
