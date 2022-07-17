package app.webca.codingtest.ch10_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 * 위상 정렬
 * 순서가 정해져 있는 일련의 작업을 차례대로 수행해야 할 때 (ex. 수업 수강 순서)
 * </pre>
 */
public class Ch1001_TopologySort {

    private static void topology_sort(int n, int[][] array) {
        int[] indegree = new int[n + 1];

        // 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 진입차수 초기화 및 배열 정보를 그래프에 삽입
        for (int[] arrow : array) {
            indegree[arrow[1]]++;
            graph.get(arrow[0]).add(arrow[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        // 진입차수가 0인 노드들을 queue에 삽입
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (queue.isEmpty() == false) {
            int node = queue.poll();
            result.add(node);
            for (Integer to : graph.get(node)) {
                indegree[to]--;
                if (indegree[to] == 0) {
                    queue.offer(to);
                }
            }
        }

        for (Integer node : result) {
            System.out.print(node + " ");
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] array = { { 1, 2 }, { 1, 5 }, { 2, 3 }, { 2, 6 }, { 3, 4 }, { 4, 7 }, { 5, 6 }, { 6, 4 } };
        topology_sort(n, array);
    }
}
