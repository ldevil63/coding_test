package app.webca.codingtest.ch05_dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 미로 탈출
 * 
 * N x M 크기의 직사각형 형태의 미로. 괴물을 피해 탈출해야 한다.
 * 시작 위치는 (1, 1)이고 미로의 출구는 (N, M)의 위치에 존재한다.
 * 괴물이 있는 부분은 0으로, 없는 부분은 1로 표시되어 있다.
 * 탈출에 필요한 최소칸을 구하라.
 * 칸을 셀 때는 시작 칸과 마지막 칸을 모두 포함해서 계산한다.
 * </pre>
 */
public class Ch0504_BFS {

    private static class Position {
        final int row;
        final int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private final static int[] dcol = { 0, 0, -1, 1 };
    private final static int[] drow = { -1, 1, 0, 0 };

    // BFS 를 이용하여 출구까지의 step 을 모두 기록한다.
    public static int bfs(int[][] graph) {

        int rowCount = graph.length;
        int colCount = graph[0].length;

        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0));

        // 탈출은 항상 가능한 입력 조건
        while (queue.isEmpty() == false) {
            Position pos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nrow = pos.row + drow[i];
                int ncol = pos.col + dcol[i];
                // 영역을 벗어나면 무시
                if (nrow < 0 || rowCount <= nrow || ncol < 0 || colCount <= ncol) {
                    continue;
                }
                // 괴물이 있으면 무시
                if (graph[nrow][ncol] == 0) {
                    continue;
                }
                // 한번도 방문한 적이 없는 경우에만 해당 노드까지의 최단거리로 덮어쓰기
                // 해당 노드로 접근할 수 있는 최단 거리로 쓰여진다.
                if (graph[nrow][ncol] == 1) {
                    queue.offer(new Position(nrow, ncol));
                    graph[nrow][ncol] = graph[pos.row][pos.col] + 1;
                    if (nrow == rowCount - 1 && ncol == colCount - 1) {
                        // 출구를 찾았으면 더 진행할 필요 없다.
                        queue.clear();
                        break;
                    }
                }
            }
        }

        System.out.println("graph :");
        for (int[] row : graph) {
            for (int minStep : row) {
                System.out.print(String.format("%02d ", minStep));
            }
            System.out.println("");
        }
        return graph[rowCount - 1][colCount - 1];
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 1, 0, 1, 0, 1, 0 },
                { 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 }
        };

        int count = bfs(graph);
        System.out.println("result : " + count);
    }
}
