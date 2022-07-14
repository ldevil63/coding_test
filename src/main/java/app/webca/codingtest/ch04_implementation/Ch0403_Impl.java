package app.webca.codingtest.ch04_implementation;

/**
 * <pre>
 * 게임 개발
 * 
 * 맵은 N X M 크기의 직사각형으로, 각각의 칸은 육지 또는 바다(갈 수 없음)이다. 캐릭터는 동서남북 중 한 곳을 바라본다.
 * 맵의 각 칸은 (A, B)로 나타낼 수 있고, A는 북쪽으로부터 떨어진 칸의 개수, B는 서쪽으로부터 떨어진 칸의 개수이다.
 *  1. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 갈 곳을 정한다.
 *  2. 왼쪽 방향으로 회전 후 이미 가본 칸이 아니라면 가고, 아니면 1단계로 돌아간다.
 *  3. 4방향 모두 이미 가본 칸이거나 바다로 되어 있는 칸인 경우 바로보는 방향을 유지한 채로 뒤로 한칸 간 후 1단계로 돌아간다.
 *     이때 뒤쪽 방향이 바다인 칸이라 뒤로 갈 수 없는 경우에는 움직임을 멈춘다.
 * 이동이 끝난 후 방문한 칸의 수를 출력한다.
 * </pre>
 */
public class Ch0403_Impl {

    // 회전 후 바라보는 방향이 북(0), 동(1), 남(2), 서(3) 일 때 이동해야 하는 칸 수
    final static int[] dx = { 0, 1, 0, -1 };
    final static int[] dy = { -1, 0, 1, 0 };

    final static int[][] map = { 
        { 1, 1, 1, 1 },
        { 1, 0, 0, 1 },
        { 1, 1, 0, 1 },
        { 1, 1, 1, 1 }
    };
    
    final static int n = map.length;
    final static int m = map[0].length;

    private static int turnLeft(int d) {
        return (d == 0)? 3 : d - 1;
    }

    private static void visit(int[][] visitMap, int x, int y) {
        visitMap[x][y] = 1;
    }

    private static boolean isMovable(int[][] visitMap, int x, int y) {
        if (0 <= x && x < m && 0 <= y && y < n) {
            return visitMap[x][y] == 0;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 1;
        int d = 0;
        
        int[][] visitMap = map.clone();
        int count = 1;
        if (isMovable(visitMap, x, y) == false) {
            System.err.println("invalid start position");
            return;
        }
        while (true) {
            for (int i = 0; i < 4; i++) {
                d = turnLeft(d);
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (isMovable(visitMap, nx, ny)) {
                    x = nx;
                    y = ny;
                    visit(visitMap, x, y);
                    count++;
                    break;
                }
            }

            // backstep
            int px = x - dx[d];
            int py = y - dy[d];
            if (isMovable(visitMap, px, py) == false) {
                break;
            }
            x = px;
            x = py;
        }

        System.out.println("result : " + count);
    }
}
