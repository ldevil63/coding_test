package app.webca.codingtest.ch04_implementation;

/**
 * <pre>
 * 시각
 * 
 * 정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중 3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성하시오.
 * </pre>
 */
public class Ch0401_Impl_2 {
    
    public static void main(String[] args) {
        int N = 5;
        int count = 0;
        for (int h = 0; h <= N; h++) {
            if (String.valueOf(h).contains("3")) {
                count += 60 * 60;
                continue;
            }
            for (int m = 0; m <= 59; m++) {
                if (String.valueOf(m).contains("3")) {
                    count += 60;
                    continue;
                }
                for (int s = 0; s <= 59; s++) {
                    if (String.valueOf(s).contains("3")) {
                        count++;
                    }
                }
            }
        }
        System.out.println("count : " + count);
    }
}
