package app.webca.codingtest.ch07_search;

public class Ch0701_SequentialSearch {

    private static int sequential_search(String[] array, String target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        String[] array = { "Hanul", "Jonggu", "Dongbin", "Taeil", "Sangwook" };
        System.out.println("result : " + sequential_search(array, "Dongbin"));
    }
}
