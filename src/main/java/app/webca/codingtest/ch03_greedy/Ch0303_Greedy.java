package app.webca.codingtest.ch03_greedy;

import app.webca.codingtest._common.NumberUtil;

/**
 * <pre>
 * 숫자 카드 게임
 * 
 * 가장 높은 숫자가 쓰인 카드 한 장을 뽑는 게임이다.
 * 1. 숫자가 쓰인 카드들이 N x M 형태로 놓여 있다. 이때 N은 행의 개수를 의미하며, M은 열의 개수를 의미한다.
 *    3 1 2
 *    4 1 4
 *    2 2 2
 * 2. 먼저 뽑고자 하는 카드가 포함되어 있는 행을 선택한다.
 * 3. 그 다음 선택된 행에 포함된 카드들 중 가장 숫자가 낮은 카드를 뽑아야 한다.
 * 4. 따라서 처음에 카드를 골라낼 행을 선택할 때, 이후에 해당 행에서 가장 숫자가 낮은 카드를 뽑을 것을 고려하여
 *    최종적으로 가장 높은 숫자의 카드를 뽑을 수 있도록 전략을 세워야 한다.
 * </pre>
 */
public class Ch0303_Greedy {

    public static void main(String[] args) {
        // 각 행의 가장 낮은 숫자가 가장 높은 수인 행을 선택해야 한다.
        // 어쨌든 각 행의 가장 낮은 숫자 중 가장 높은 수를 출력하면 된다.
        int[][] numMatrix1 = {
                { 3, 1, 2 },
                { 4, 1, 4 },
                { 2, 2, 2 }
        };
        int[][] numMatrix2 = {
                { 7, 3, 1, 8 },
                { 3, 3, 3, 4 }
        };

        System.out.println("result : " + findMaxNum(numMatrix1));
        System.out.println("result : " + findMaxNum(numMatrix2));
    }

    private static int findMaxNum(int[][] numMatrix) {
        int[] minArray = new int[numMatrix.length];
        for (int i = 0; i < numMatrix.length; i++) {
            minArray[i] = NumberUtil.min(numMatrix[i]);
        }
        return NumberUtil.max(minArray);
    }
}
