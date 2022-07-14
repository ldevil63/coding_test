package app.webca.codingtest.ch05_dfs_bfs;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 * DFS (Depth First Search)
 * </pre>
 */
public class Ch0502_DFS_stack {

    public static void dfs(List<List<Integer>> graph, int node) {
        boolean[] visited = new boolean[graph.size()];

        Stack<Integer> stack = new Stack<>();
        stack.push(node); // 최초 노드 추가

        while (stack.empty() == false) {
            int current = stack.pop();
            // 나중에 추가된 노드에 의해 이미 처리된 노드는 무시
            if (visited[current]) {
                continue;
            }
            visited[current] = true;
            System.out.println(current + ", stack : " + stack);
            List<Integer> adjacentNodes = graph.get(current);
            // 후입선출이기 때문에 작은 숫자부터 처리하려면 큰 수부터 stack 에 입력
            for (int i = adjacentNodes.size() - 1; i >= 0; i--) {
                int next = adjacentNodes.get(i);
                if (visited[next] == false) {
                    stack.push(next);
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
        dfs(graph, 1);
    }
}
