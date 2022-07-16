package app.webca.codingtest.ch08_dynamic;

import java.math.BigInteger;

public class Ch0801_Fibonacci {

    // using recursion (too slow)
    // O(2^N)
    private static long recursion(int x) {
        if (x == 1 || x == 2) {
            return 1L;
        }
        return recursion(x - 1) + recursion(x - 2);
    }

    // memoization : topdown 방식 (재귀함수)
    // O(N)
    private static BigInteger memoization(BigInteger[] table, int x) {
        if (table[x] == null) {
            if (x == 1 || x == 2) {
                table[x] = BigInteger.ONE;
            } else {
                table[x] = memoization(table, x - 1).add(memoization(table, x - 2));
            }
        }
        return table[x];
    }

    // dynamic : bottomup 방식 (반복문)
    // O(N)
    private static BigInteger dynamic(int x) {
        BigInteger[] dptable = new BigInteger[x + 1];
        dptable[1] = BigInteger.ONE;
        dptable[2] = BigInteger.ONE;
        for (int i = 3; i <= x; i++) {
            dptable[i] = dptable[i - 1].add(dptable[i - 2]);
        }
        return dptable[x];
    }

    public static void main(String[] args) {
        int x = 44; // 내 PC에서 1초 정도?
        System.out.println("result : " + recursion(x));

        x = 500;
        BigInteger[] table = new BigInteger[x + 1];
        System.out.println("result : " + memoization(table, x));
        System.out.println("result : " + dynamic(x));
    }
}
