package app.webca.codingtest.ch04_implementation;

/**
 * <pre>
 * 왕실의 나이트
 * 
 * 8 x 8 좌표 평면. 나이트는 L자 형태로만 이동할 수 있고, 다음의 방법으로만 이동할 수 있다.
 *  1. 수평으로 두 칸 이동한 뒤에 수직으로 한칸 이동하기
 *  2. 수직으로 두 칸 이동한 뒤에 수평으로 한칸 이동하기
 * 현재 위치가 주어였을 때 나이트가 이동할 수 있는 경우의 수를 출력하라
 *   a  b  c  d  e  f  g  h
 * 1 
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * </pre>
 */
public class Ch0402_Impl {

    // 이동에 장애물이 없으므로 순서는 관련 없음
    private static final int[][] steps = {
        {-2, -1}, {-2,  1}, // 왼쪽으로 2칸 이동
        { 2, -1}, { 2,  1}, // 오른쪽으로 2칸 이동
        {-1, -2}, { 1, -2}, // 위로 2칸 이동
        {-1,  2}, { 1,  2}  // 아래로 2칸 이동
    };

    public static void main(String[] args) {
        String p = "a1";
        int dx = p.charAt(0) - 'a' + 1;
        int dy = p.charAt(1) - '0';

        int count = 0;
        for (int[] step : steps) {
            int nx = dx + step[0];
            int ny = dy + step[1];
            if ((1 <= nx && nx <= 8) && (1 <= ny && ny <= 8)) {
                count++;
            }
        }

        System.out.println("result : " + count);
    }
    
}
