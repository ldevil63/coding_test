package app.webca.codingtest.ch04_implementation;

/**
 * <pre>
 * 상하좌우
 * 
 * 여행가 A는 N X N 크기의 정사각형 공간 위에 서 있다.
 * 여행가 A는 상,하,좌,우 방향으로 이동할 수 있으며, 공간을 벗어나는 움직임은 무시된다.
 * (L,R,U,D) 로 표시된 계획서가 있고, 시작 좌표는 항상 (1, 1) 이다.
 * </pre>
 */
public class Ch0401_Impl_1 {

    public static void main(String[] args) {
        int n = 5;
        char[] plan = { 'R', 'R', 'R', 'U', 'D', 'D' };

        int col = 1;
        int row = 1;
        for (char d : plan) {
            if (d == 'U' && row > 1) {
                row--;
            } else if (d == 'D' && row < n) {
                row++;
            } else if (d == 'L' && col > 1) {
                col--;
            } else if (d == 'R' && col < n) {
                col++;
            }
        }

        System.out.println(String.format("now in : (%d,%d)", row, col));
    }
}
