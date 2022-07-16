package app.webca.codingtest.ch08_dynamic;

/**
 * <pre>
 * 바닥 공사
 * 
 * 가로의 길이가 N, 세로의 길이가 2인 직사각형 형태의 얇은 바닥이 있다.
 * 이 바닥을 1x2, 2x1, 2x2 덥개를 이용해 채우고자 할 때 가능한 모든 경우의 수를 796796 으로 나눈 나머지를 출력하라.
 * </pre>
 */
public class Ch0804 {

    public static void main(String[] args) {
        // # 세로로 어긋나게 쌓으면 모든 바닥을 채우는 것이 불가능하다. (반만 채워져 있는 경우는 없음)
        // 1. 이전까지 모두 채워져 있는 경우 한가지(세로 1개) 경우의 수 밖에 없다. (선택할 수 없으므로 경우의 수가 증가하지 않음)
        // 2. 이전전까지 모두 채워져 있는 경우 2가지(가로 2개, 정사각형 1개) 경우의 수가 있다. (2가지 중 선택)
        // 2.1 세로로 두줄을 모두 채울 경우 1과 동일한 경우의 수가 된다.
        int n = 100;
        int[] dptable = new int[n];

        dptable[0] = 1;
        dptable[1] = 3;
        for (int i = 2; i < n; i++) {
            // 나머지 연산이 다음 연산에 영향을 미치치 않는 이유?
            dptable[i] = (dptable[i - 1] + (dptable[i - 2] * 2)) % 796796;
        }

        System.out.println("result : " + dptable[n - 1]);
    }
}
