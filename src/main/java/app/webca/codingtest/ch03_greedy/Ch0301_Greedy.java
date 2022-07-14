package app.webca.codingtest.ch03_greedy;

/**
 * <pre>
 * 거스름돈
 * 
 * 1. 거슬러줘야 할 동전의 최소 개수
 * </pre>
 */
public class Ch0301_Greedy {

    public static void main(String[] args) {
        int count = 0;
        int n = 1260;
        int[] coinTypes = { 500, 100, 50, 10 };

        // 계산
        for (int coinType : coinTypes) {
            count += n / coinType;
            n %= coinType;
        }

        System.out.println("count = " + count);
    }
}
