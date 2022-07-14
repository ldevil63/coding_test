package app.webca.codingtest.ch05_dfs_bfs;

/**
 * <pre>
 * DFS (Depth First Search)
 * </pre>
 */
public class Ch0502_DFS_recursion {

    public static void dfs(int[][] graph, int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int next : graph[node]) {
            if (visited[next] == false) {
                dfs(graph, next, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0 }, // 접근하지 않음
                { 2, 3, 8 },
                { 1, 7 },
                { 1, 4, 5 },
                { 3, 5 },
                { 3, 4 },
                { 7 },
                { 2, 6, 8 },
                { 1, 7 }
        };
        boolean[] visited = new boolean[graph.length];
        dfs(graph, 1, visited);
    }

}
