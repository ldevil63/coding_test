package app.webca.codingtest.ch10_graph;

public class Ch1001_DetectCycling {

    private static int find_parent(int[] parents, int x) {
        if (parents[x] != x) {
            parents[x] = find_parent(parents, parents[x]);
        }
        return parents[x];
    }

    private static void union_parent(int[] parents, int a, int b) {
        a = find_parent(parents, a);
        b = find_parent(parents, b);
        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    private static boolean detect_cycle(int n, int[][] edges) {
        // parents 초기화
        int[] parents = new int[n + 1];
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            if (find_parent(parents, edge[0]) == find_parent(parents, edge[1])) {
                return true;
            }
            union_parent(parents, edge[0], edge[1]);
        }
        return false;
    }

    public static void main(String[] args) {
        // Cycling : 원소가 연결됨
        int n = 3;
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };

        if (detect_cycle(n, edges)) {
            System.out.println("사이클이 발생했습니다.");
        } else {
            System.out.println("사이클이 발생하지 않았습니다.");
        }
    }

}
