package app.webca.codingtest.ch08_dynamic;

/**
 * <pre>
 * 개미 전사
 * 
 * 일직선의 식량창고가 있고 각 창고에 식량이 얼마나 있는지 미리 확인해두었다.
 * 이미 약탈한 창고의 옆 창고는 약탈할 수 없다.
 * 약탈할 수 있는 최댓값을 구하라.
 * </pre>
 */
public class Ch0803 {

    public static void main(String[] args) {
        // 현재 창고를 약탈할지 안할지 결정하기 위해 이전 창고와 이 전전 창고까지의 합만 확인하면 된다.
        // int[] array = { 1, 3, 1, 5 };
        int[] array = { 4, 1, 2, 3 };
        int[] dptable = new int[array.length];

        dptable[0] = array[0];
        dptable[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            dptable[i] = Math.max(dptable[i - 2] + array[i], dptable[i - 1]);
        }
        System.out.println("result : " + dptable[dptable.length - 1]);
    }

}
