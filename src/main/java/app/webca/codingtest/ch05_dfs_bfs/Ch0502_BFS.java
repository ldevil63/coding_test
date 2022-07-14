package app.webca.codingtest.ch05_dfs_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 * BFS (Breadth First Search)
 * </pre>
 */
public class Ch0502_BFS {

    public static void bfs(List<List<Integer>> graph, int node) {
        boolean[] visited = new boolean[graph.size()];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node); // 최초 노드 삽입
        visited[node] = true;

        while (queue.isEmpty() == false) {
            int current = queue.poll();
            System.out.println(current + ", queue : " + queue);
            List<Integer> adjacentNodes = graph.get(current);
            for (int next : adjacentNodes) {
                if (visited[next] == false) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(0),
                Arrays.asList(2, 3, 8),
                Arrays.asList(1, 7),
                Arrays.asList(1, 4, 5),
                Arrays.asList(3, 5),
                Arrays.asList(3, 4),
                Arrays.asList(7),
                Arrays.asList(2, 6, 8),
                Arrays.asList(1, 7));
        bfs(graph, 1);
    }
}
