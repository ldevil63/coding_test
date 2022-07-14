package app.webca.codingtest.ch05_dfs_bfs;

/**
 * <pre>
 * 음료수 얼려 먹기
 * 
 * N x M 크기의 얼음 틀이 있다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다.
 * 구멍이 뚫려 있는 부분끼리 붙어 있는 경우 서로 연결되어 있는 것으로 간주한다.
 * 얼음 틀의 모양이 주어졌을 때, 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하라.
 *   0 0 1 1 0
 *   0 0 0 1 1
 *   1 1 1 1 1
 *   0 0 0 0 0
 * </pre>
 */
public class Ch0503_DFS {

    // DFS 여야 하는 이유는? BFS 는 왜 안되나?
    public static boolean dfs(int[][] graph, int row, int col) {
        if (row < 0 || graph.length <= row || col < 0 || graph[0].length <= col) {
            return false;
        }
        if (graph[row][col] == 0) {
            graph[row][col] = 1;
            // 인접한 모든 노드들 방문 처리 (개수 카운트 안함)
            dfs(graph, row - 1, col);
            dfs(graph, row + 1, col);
            dfs(graph, row, col - 1);
            dfs(graph, row, col + 1);
            return true;
        }
        return false;
    }

    public static void sample1() {
        int[][] graph = {
                { 0, 0, 1, 1, 0 },
                { 0, 0, 0, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0 }
        };
        int count = 0;
        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[row].length; col++) {
                if (dfs(graph, row, col)) {
                    count++;
                }
            }
        }
        System.out.println("result : " + count);
    }

    public static void sample2() {
        int[][] graph = {
                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0 },
                { 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
                { 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1 },
                { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 }
        };
        int count = 0;
        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[row].length; col++) {
                if (dfs(graph, row, col)) {
                    count++;
                }
            }
        }
        System.out.println("result : " + count);
    }

    public static void main(String[] args) {
        sample1();
        sample2();
    }
}
