package silver;


import java.util.Scanner;

public class BOJ_1912_ContinuousSum {


    static void main() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] Ns = new int[N];
        for (int i = 0; i < N; i++) { // 정수를 저장하는 배열
            Ns[i] = scanner.nextInt();
        }

        // DP 시작 (i번째 숫자를 마지막으로 포함한 최대 연속합)
        int[] dp = new int[N];

        // 초기값 설정
        dp[0] = Ns[0]; // 첫번째 정수를 누적합 첫번째 인덱스에 저장(맨처음은 비교할 것이 없음)
        int maxResult = Ns[0];

        for (int i = 1; i < N; i++) { // 우리는 값이 들어간 0 말고 1에서부터 누적합의 최대를 업뎃한다.

            dp[i] = Math.max(Ns[i]+ dp[i-1], Ns[i]);

            if (dp[i] > maxResult) {
                maxResult = dp[i];
            }
        }

        System.out.println(maxResult);
    }

}
