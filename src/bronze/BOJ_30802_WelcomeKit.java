package bronze;

import java.util.Scanner;

public class BOJ_30802_WelcomeKit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = scanner.nextInt(); // 첫째줄
        int[] size = new int[6];

        for (int i = 0; i < 6; i++) {
            size[i] = scanner.nextInt(); // 둘째줄
        }

        // 조건 확인
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += size[i];
        }

        if (sum == people) {
            int t = scanner.nextInt();
            int p = scanner.nextInt();

            int shirt = 0;

            // 사이즈 별로 올림 ⚠️ ️
            for (int i = 0; i < size.length; i++) {
                shirt += (size[i] + t - 1) /t;
            }
            /* 자바는 '정수끼리 나누면 버림' ( 4/5 = 0 인데 실제로는 1묶음이 필요. 6/5 = 1인데 실제로는 2묶음이 필요)
               그래서 t - 1 을 더하면 (4 + 5 - 1) / 5 = 1 로 0에서 1로 바뀐다.
               (t로 나눠지니까 t를 하나 더하면 값이 1이 추가됨. 무조건 1묶음은 사니까 더해져서 t가 되어 +1 이 되게 t-1 로 설정)
             */
            int Pen = people / p;
            int penPlus = people % p;

            System.out.println(shirt);
            System.out.println(Pen +" "+penPlus);

        }
    }
}
