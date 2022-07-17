package app.webca.codingtest.ch09_shortest_path;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Ch0901_Dijkstra_advanced {

    private static class Line {
        final int to;
        final int value;

        Line(int to, int value) {
            this.to = to;
            this.value = value;
        }
    }

    private static final int INF = 987654321;

    // O(ElogV)
    private static void dijkstra(List<List<Line>> lines, int start) {
        boolean[] visited = new boolean[lines.size()];
        int[] distance = new int[lines.size()];

        // 각 노드를 INF 로 초기화
        Arrays.fill(distance, INF);

        // 시작 노드 거리 설정
        distance[start] = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(start);

        while (queue.isEmpty() == false) {
            int node = queue.poll();
            if (visited[node] == true) {
                // 최소거리 갱신으로 인해 이미 처리된 노드
                continue;
            }
            visited[node] = true;
            for (Line line : lines.get(node)) {
                distance[line.to] = Math.min(distance[node] + line.value, distance[line.to]);
                queue.offer(line.to);
            }
        }

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    public static void main(String[] args) {
        final List<List<Line>> lines = Arrays.asList(
                Collections.emptyList(),
                Arrays.asList(new Line(2, 2), new Line(3, 5), new Line(4, 1)),
                Arrays.asList(new Line(3, 3), new Line(4, 2)),
                Arrays.asList(new Line(2, 3), new Line(6, 5)),
                Arrays.asList(new Line(3, 3), new Line(5, 1)),
                Arrays.asList(new Line(3, 1), new Line(6, 2)),
                Collections.emptyList());

        dijkstra(lines, 1);
    }

}
