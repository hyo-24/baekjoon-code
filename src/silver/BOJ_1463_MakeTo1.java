package silver;

import java.util.Scanner;

public class BOJ_1463_MakeTo1 {

    static void main() {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int[] dp = new int[x + 1];

        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i-1] +1;
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            }
        }

        int countMin = dp[x];
        System.out.println(countMin);
    }
}
