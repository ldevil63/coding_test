package app.webca.codingtest.ch09_shortest_path;

/**
 * <pre>
 * 미래 도시
 * 
 * N개의 회사가 있다.
 * 모든 회사 사이에 이동시간은 연결된 도로만 있다면 1시간으로 일정하다.
 * 1부터 K를 거쳐 X 까지 이동에 필요한 최소시간을 구하라.
 * </pre>
 */
public class Ch0902 {

    private static final int INF = 987654321;

    private static int floyd_warshall(int n, int s, int x, int k, int[][] lines) {

        // 행렬 초기화
        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = INF;
                }
            }
        }

        // 간선 연결
        for (int[] line : lines) {
            // 방향 없음
            matrix[line[0]][line[1]] = 1;
            matrix[line[1]][line[0]] = 1;
        }

        // 플로이드 워셜 알고리즘 실행
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                for (int m = 1; m < matrix.length; m++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][m] + matrix[m][j]);
                }
            }
        }

        if (matrix[1][k] == INF || matrix[k][x] == INF) {
            return -1;
        }

        return matrix[1][k] + matrix[k][x];
    }

    public static void main(String[] args) {
        // N의 범위가 100 이하로 한정적이므로 플로이드 워셜 알고리즘을 사용한다.
        final int[][] lines = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 4 }, { 3, 4 }, { 3, 5 }, { 4, 5 } };
        final int[][] lines2 = { { 1, 3 }, { 2, 4 } };

        System.out.println("result : " + floyd_warshall(5, 1, 4, 5, lines));
        System.out.println("result : " + floyd_warshall(4, 1, 3, 4, lines2));
    }
}
