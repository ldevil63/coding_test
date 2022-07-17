package app.webca.codingtest.ch10_graph;

public class Ch1001_DisjointSets_path_compression {

    private static int find_parent(int[] parents, int x) {
        if (parents[x] != x) {
            // return find_parent(parents, parents[x]);
            // 경로 압축 기법
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

    public static void main(String[] args) {
        int n = 6;

        // parents 초기화
        int[] parents = new int[n + 1];
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }

        // union 실행
        int[][] unions = { { 1, 4 }, { 2, 3 }, { 2, 4 }, { 5, 6 } };
        for (int[] union : unions) {
            union_parent(parents, union[0], union[1]);
        }

        System.out.print("각 원소가 속한 집합 :");
        for (int i = 1; i <= n; i++) {
            System.out.print(" " + find_parent(parents, i));
        }
        System.out.println();

        System.out.print("부모 테이블 :");
        for (int i = 1; i <= n; i++) {
            System.out.print(" " + parents[i]);
        }
    }

}
