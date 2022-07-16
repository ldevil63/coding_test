package app.webca.codingtest.ch08_dynamic;

import java.util.Arrays;

/**
 * <pre>
 * 효율적인 화폐 구성
 * 
 * N가지 종류의 화폐가 있다. 이 화폐를 이용해서 M원이 되도록 하려고 한다.
 * M원을 만들기 위한 최소 화폐의 수를 출력한다. 불가능할 경우 -1 을 출력한다.
 * </pre>
 */
public class Ch0805 {

    private static final int INF = 987654321;

    public static int calc(int m, int[] moneys) {
        // 화폐 단위가 더 작은 화폐의 배수라고 정해져있지 않으므로, 큰 화폐부터 처리하는 방식으로 할 수 없다.
        int[] dptable = new int[m + 1];
        Arrays.fill(dptable, INF); // 불가능한 값. min 사용을 위해 큰 값으로 초기화

        dptable[0] = 0; // 화폐 하나만 사용하면 될 때 dptable 갱신을 위해
        for (int i = 1; i <= m; i++) {
            for (int money : moneys) {
                if (money <= i && dptable[i - money] != INF) {
                    dptable[i] = Math.min(dptable[i], dptable[i - money] + 1);
                }
            }
        }

        return (dptable[m] != INF) ? dptable[m] : -1;
    }

    public static void main(String[] args) {
        System.out.println("result : " + calc(15, new int[] { 2, 3 }));
        System.out.println("result : " + calc(4, new int[] { 3, 5, 7 }));
        System.out.println("result : " + calc(3, new int[] { 3, 5, 7 }));
        System.out.println("result : " + calc(8, new int[] { 3, 5, 7 }));
        System.out.println("result : " + calc(15, new int[] { 3, 5, 7 }));
        System.out.println("result : " + calc(23, new int[] { 3, 5, 7 }));
    }
}
