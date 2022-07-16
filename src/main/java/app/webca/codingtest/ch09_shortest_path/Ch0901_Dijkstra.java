package app.webca.codingtest.ch09_shortest_path;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ch0901_Dijkstra {

    private static class Line {
        final int to;
        final int value;

        Line(int to, int value) {
            this.to = to;
            this.value = value;
        }
    }

    private static final int INF = 987654321;

    private static int getSmallestNode(boolean[] visited, int[] distance) {
        int minIndex = -1;
        int minValue = INF;
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == false && distance[i] < minValue) {
                minIndex = i;
                minValue = distance[i];
            }
        }
        return minIndex;
    }

    // O(V^2)
    private static void dijkstra(List<List<Line>> lines, int start) {
        boolean[] visited = new boolean[lines.size()];
        int[] distance = new int[lines.size()];

        // 각 노드를 INF 로 초기화
        Arrays.fill(distance, INF);

        // 첫번째 방문 처리
        visited[start] = true;
        distance[start] = 0;
        for (Line line : lines.get(start)) {
            distance[line.to] = line.value;
        }

        while (true) {
            int node = getSmallestNode(visited, distance);
            if (node == -1) {
                break;
            }
            visited[node] = true;
            for (Line line : lines.get(node)) {
                distance[line.to] = Math.min(distance[node] + line.value, distance[line.to]);
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
