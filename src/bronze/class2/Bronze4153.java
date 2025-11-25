package bronze.class2;

import java.util.Arrays;
import java.util.Scanner;

public class Bronze4153 {

    /* 1. 입력이 여러 줄 들어온다.
       2. 각 줄에는 세 변이 들어온다.
       3. 세 변을 오름차순 정렬한다.
       4. 피타고라스 정리 검사
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int[] t = new int[3];
            for (int i = 0; i < 3; i++) {
                //int l = scanner.nextInt(); t[i] = l; 이렇게 따로 하지 않고 밑에 처럼 한번에 하자
                t[i] = scanner.nextInt();
            }
            if (t[0] == 0 && t[1] == 0 && t[2] == 0) {
                break;
            }

            Arrays.sort(t); // ➡️ 오름차순 정렬 (작은거 -> 큰거)

            int a = t[0];
            int b = t[1];
            int c = t[2];

            if (a * a + b * b == c * c) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }

        }







    }
}
