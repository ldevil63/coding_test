package app.webca.codingtest.ch09_shortest_path;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <pre>
 * 전보
 * 
 * N개의 도시가 있다.
 * X에서 Y에 전보를 보내려면 X에서 Y로 향하는 통로가 설치되어 있어야 한다. (X -> Y (O), Y -> X (X))
 * 통로를 거쳐 메시지를 보낼 때는 일정한 시간이 소요된다.
 * 메시지는 동시에 여러개를 보낼 수 있다.
 * 도시 C 에서 보낸 메시지를 받는 도시의 총 개수와 총 걸리는 시간을 공백으로 구분하여 출력한다.
 * </pre>
 */
public class Ch0903 {

    private static class Line {
        int to;
        int value;

        Line(int to, int value) {
            this.to = to;
            this.value = value;
        }
    }

    private static final int INF = 987654321;

    public static void main(String[] args) {
        final int n = 3;
        final int c = 1;
        final List<List<Line>> lines = Arrays.asList(
                Collections.emptyList(),
                Arrays.asList(new Line(2, 4), new Line(3, 2)),
                Collections.emptyList(),
                Collections.emptyList());

        boolean[] visited = new boolean[n + 1];
        int[] nodes = new int[n + 1];
        Arrays.fill(nodes, INF);

        nodes[c] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(c);

        while (queue.isEmpty() == false) {
            Integer node = queue.poll();
            if (visited[node] == true) {
                continue;
            }
            visited[node] = true;
            for (Line line : lines.get(node)) {
                if (nodes[node] + line.value < nodes[line.to]) {
                    nodes[line.to] = nodes[node] + line.value;
                    queue.offer(line.to);
                }
            }
        }

        int count = 0;
        int max = 0;
        for (int i = 1; i < nodes.length; i++) {
            if (i != c && nodes[i] != INF) {
                count++;
                max = Math.max(max, nodes[i]);
            }
        }

        System.out.println(count + " " + max);
    }
}
