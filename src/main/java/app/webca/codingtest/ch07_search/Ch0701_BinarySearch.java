package app.webca.codingtest.ch07_search;

public class Ch0701_BinarySearch {

    private static int binary_search(Integer[] array, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = (start + end) / 2;
        if (array[middle] < target) {
            return binary_search(array, target, middle + 1, end);
        } else if (target < array[middle]) {
            return binary_search(array, target, start, middle - 1);
        } else {
            return middle;
        }
    }
    
    public static void main(String[] args) {
        Integer[] array = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
        for (int i = 0; i <= 20; i++) {
            System.out.println("result : " + binary_search(array, i, 0, array.length - 1));
        }
    }
}
