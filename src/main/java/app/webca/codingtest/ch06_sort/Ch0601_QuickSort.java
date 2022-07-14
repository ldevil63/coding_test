package app.webca.codingtest.ch06_sort;

public class Ch0601_QuickSort {

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

    private static void qsort_left_pivot(int[] array, int start, int end) {
        // 정렬할 원소가 1개 이하인 경우 종료
        if (start >= end) {
            return;
        }
        int pivot = start;
        int left = start;
        int right = end;
        while(left < right) {
            while(left < right && array[left] < array[pivot]) {
                left++;
            }
            while(left < right && array[right] > array[pivot]) {
                right--;
            }
            if (left < right) {
                swap(array, left, right);
            }
        }
        swap(array, left, pivot);
        qsort_left_pivot(array, start, left - 1);
        qsort_left_pivot(array, left + 1, end);
    }

    private static int partition_middle(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2];
        while (true) {
            // 왼쪽부터 pivot 보다 크거나 같은 값 찾기
            while(array[left] < pivot) {
                left++;
            }
            // 오른쪽부터 pivot 보다 작거나 같은 값 찾기
            while(left <= right && pivot < array[right]) {
                right--;
            }
            // left 와 right 가 교차한 경우 right 를 새로운 pivot 으로
            if (right <= left) {
                return right;
            }
            swap(array, left, right);
        }
    }

    private static void qsort_middle_pivot(int[] array, int left, int right) {
        if (left < right) {
            int pivot = partition_middle(array, left, right);
            qsort_middle_pivot(array, left, pivot);
            qsort_middle_pivot(array, pivot + 1, right);
        }
    }

    public static void main(String[] args) {
        // 퀵 정렬
        //  1. 기준 데이터를 정한다.
        //  2. 왼쪽부터 기준 데이터보다 큰 데이터를 찾고, 오른쪽부터 기준 데이터보다 작은 데이터를 찾아 교환한다.
        //  3. 기준 데이터보다 큰 데이터를 찾지 못한 경우, 기준 데이터와 작은 데이터 인덱스를 교체한다.
        //  4. 기준 데이터 왼쪽과 기준 데이터 오른쪽을 다시 퀵 정렬을 실행한다.
        // 속도 : O(NlogN), 단 이미 정렬된 데이터인 경우 매우 느리다.

        {
            int[] array1 = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };
            qsort_left_pivot(array1, 0, array1.length - 1);
            print(array1);
        }

        {
            int[] array2 = { 9, 8, 7, 6, 1, 4, 3, 2, 5, 0 };
            qsort_middle_pivot(array2, 0, array2.length - 1);
            print(array2);
        }
    }
    
}
