package app.webca.codingtest.ch06_sort;

public class Ch0601_InsertionSort {

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
        
        // 삽입정렬 : 왼쪽의 정렬된 데이터의 적절한 위치에 삽입한다.
        // 속도 : O(N^2), 단 이미 정렬된 데이터인 경우 O(N) 에 가깝다.
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // 왼쪽이 오른쪽보다 작거나 같으면 종료한다.
                if (array[j] <= array[j + 1]) {
                    break;
                }
                // 왼쪽과 오른쪽을 교체한다.
                swap(array, j, j + 1);
            }
            print(array);
        }
    }
    
}
