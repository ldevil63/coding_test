package app.webca.codingtest.ch09_shortest_path;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ch0901_FloydWarshall {

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
    private static void floyd_warshall(List<List<Line>> lines) {
        int[][] matrix = new int[lines.size()][lines.size()];

        // 초기화
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = INF;
                }
            }
        }

        // 간선 정보 입력
        for (int i = 1; i < lines.size(); i++) {
            for (Line line : lines.get(i)) {
                matrix[i][line.to] = line.value;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                for (int k = 1; k < matrix.length; k++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if (matrix[i][j] == INF) {
                    System.out.print(String.format("INFINITY ", matrix[i][j]));
                } else {
                    System.out.print(String.format("%8d ", matrix[i][j]));
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        final List<List<Line>> lines = Arrays.asList(
                Collections.emptyList(),
                Arrays.asList(new Line(2, 4), new Line(4, 6)),
                Arrays.asList(new Line(1, 3), new Line(3, 7)),
                Arrays.asList(new Line(1, 5), new Line(4, 4)),
                Arrays.asList(new Line(3, 2)));

        floyd_warshall(lines);
    }
}
