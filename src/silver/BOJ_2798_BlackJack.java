package silver;

import java.util.Scanner;

public class BOJ_2798_BlackJack {

    static void main() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }

        int total = 0; // ✅ 전체 턴에서 연산 값 (갱신됨)

        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int answer = cards[i]+cards[j]+cards[k]; // ✅ 현재 턴의 연산 값

                    if (answer == m) {
                        System.out.println(answer); // 틀림 :  answer 가 m 과 같으면 현재 값인 answer 를 출력 (not total)
                        return;
                    }

                    if (answer < m && answer > total) { // ➡️(핵심) 조건에 해당하고 앞에서의 연산보다 더 조건에 해당하면 갱신 ‼️
                        total = answer;
                    }
                }
            }
        }
        System.out.println(total);

    }


}
