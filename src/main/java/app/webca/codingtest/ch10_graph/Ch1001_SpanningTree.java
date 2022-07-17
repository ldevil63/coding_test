package app.webca.codingtest.ch10_graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * 신장 트리 : 모든 노드가 서로 연결되어 있으면서 사이클이 존재하지 않는 부분 그래프 -> 트리의 성립 조건
 * 트리의 간선의 개수는 항상 노드의 개수 - 1 이다.
 * </pre>
 */
public class Ch1001_SpanningTree {

    private static class Edge {
        final int a;
        final int b;
        final int cost;

        Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        // for compare
        int getCost() {
            return this.cost;
        }
    }

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

    private static boolean detect_cycle(int[] parents, int a, int b) {
        return find_parent(parents, a) == find_parent(parents, b);
    }

    // greedy 알고리즘
    // 모든 간선을 오름차순으로 정렬
    // 가장 짧은 간선부터 집합에 포함
    // 사이클이 발생한 경우 집합에 포함시키지 않음
    private static void kruskal(int n, List<Edge> edges) {
        // cost 순으로 정렬
        List<Edge> sortedEdges = edges.stream()
                .sorted(Comparator.comparingInt(Edge::getCost))
                .collect(Collectors.toList());

        int[] parents = new int[n + 1];

        // parents 초기화
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }

        int result = 0;
        for (Edge edge : sortedEdges) {
            if (detect_cycle(parents, edge.a, edge.b)) {
                System.out.println(String.format("[%d, %d] : detect cycling", edge.a , edge.b));
                continue;
            }
            result += edge.cost;
            System.out.println(String.format("[%d, %d] : union => costs(%d)", edge.a, edge.b, result));
            union_parent(parents, edge.a, edge.b);
        }

        System.out.println("result : " + result);
    }
    
    public static void main(String[] args) {
        // N개의 도시에 도로를 놓아 모든 도시를 연결하는 최소한의 비용
        int n = 7;
        List<Edge> edges = Arrays.asList(
            new Edge(1, 2, 29),
            new Edge(1, 5, 75),
            new Edge(2, 3, 35),
            new Edge(2, 6, 34),
            new Edge(3, 4, 7),
            new Edge(4, 6, 23),
            new Edge(4, 7, 13),
            new Edge(5, 6, 53),
            new Edge(6, 7, 25)
        );

        kruskal(n, edges);
    }
}
