package silver;

import java.util.Scanner;

public class BOJ_15649_N_And_M_1 {

    static boolean[] visited;
    static int[] ns;
    static int n;
    static int m;

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        visited = new boolean[n + 1];
        ns = new int[m];

        permutation(0); // 수열 배열에서 0번째 인덱스에 값을 넣기

    }

    static void permutation(int depth) {
        if (depth == m) {
            // ✅ 이건 수열 리스트를 전부 다 만들었을 때 라는 조건이 아니고! 하나의 수열 안에 숫자를 다 채웠나를 물어보는 조건임
            for (int i : ns) {
                System.out.print(i+" ");
            }
            System.out.println();
            return; // ✅ 메서드를 끝내는게 아니다 ‼️수열 하나가 출력되고 다음 수열 만들기로 가는 것.
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ns[depth] = i;
                permutation(depth+1); // 안에서 다시 +1로 호출하기 때문에 반복문 필요 없음
                // ✅ 이때, 현재의 for문은 잠시 '일시정지' 상태가 된다. 아직 visited[i] = false까지 내려가지 못함.

                visited[i] = false; // depth == m 가 true 가 되고 return 하면 여기로 돌아와서 체크리스트 초기화
            }

        }
    }
}
