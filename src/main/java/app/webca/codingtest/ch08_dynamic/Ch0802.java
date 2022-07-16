package app.webca.codingtest.ch08_dynamic;

/**
 * <pre>
 * 1로 만들기
 * 정수 X가 주어질 때 정수 X에 사용할 수 있는 연산은 다음과 같이 4가지이다.
 *  - X가 5로 나누어 떨어지면, 5로 나눈다.
 *  - X가 3으로 나누어 떨어지면, 3으로 나눈다.
 *  - X가 2로 나누어 떨어지면, 2로 나눈다.
 *  - X에서 1을 뺀다.
 * 정수 X가 주어졌을 때, 연산 4개를 적절히 사용해서 1을 만들려고 한다.
 * 연산을 사용하는 횟수의 최솟값을 출력하시오.
 * </pre>
 */
public class Ch0802 {

    public static void main(String[] args) {
        // 큰 수로 나누는 것부터 먼저 실행하는 것이 항상 더 작은 횟수를 보장하지 않는다.
        // - ex) 26 : (13, 12, 3, 1), (25, 5, 1)
        int x = 33;
        int[] dptable = new int[x + 1];
        dptable[1] = 0;
        for (int i = 2; i <= x; i++) {
            dptable[i] = dptable[i - 1] + 1; // 항상 가능한 연산으로 초기화
            if (i % 5 == 0) {
                dptable[i] = Math.min(dptable[i / 5] + 1, dptable[i]);
            }
            if (i % 3 == 0) {
                dptable[i] = Math.min(dptable[i / 3] + 1, dptable[i]);
            }
            if (i % 2 == 0) {
                dptable[i] = Math.min(dptable[i / 2] + 1, dptable[i]);
            }
        }

        System.out.println("result : " + dptable[x]);
    }
}
