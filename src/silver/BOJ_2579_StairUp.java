package silver;

import java.util.Scanner;

public class BOJ_2579_StairUp {

    static void main() {
        Scanner scanner = new Scanner(System.in);

        int floor = scanner.nextInt();
        int[] stairs = new int[floor + 1];
        int[] dp = new int[floor + 1];


        for (int i = 1; i <= floor; i++) {
            stairs[i] = scanner.nextInt();
        }

        dp[1] = stairs[1];
        if (floor == 2) dp[2] = stairs[2] +stairs[1];
        if (floor == 3) dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);

        for (int i = 4; i <= floor; i++) {
            dp[i] = Math.max(
                    stairs[i-2] + stairs[i],
                    stairs[i-3] + stairs[i-1] + stairs[i]
            );
        }

        int result = dp[floor];
        System.out.println(result);
    }
}
