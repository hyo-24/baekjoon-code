package silver;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_11724_ConnectionNum {

    static ArrayList<Integer>[] box;
    static boolean[] check;

    static void main() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        box = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            box[i] = new ArrayList<>();
        }
        check = new boolean[N+1];

        for (int i = 1; i <= M; i++) {
            int dot1 = scanner.nextInt();
            int dot2 = scanner.nextInt();
            box[dot1].add(dot2); // 배열 안에 dot2 의 배열 리스트 참조값을 넣어야한다고 생각해서 헷갈렸다. dot2 가 인덱스도 되고 안에 값도 된다.
            box[dot2].add(dot1);
        }

        int lines = 0;
        for (int i = 1; i <= N; i++) { // main 에서 덩어리의 순회를 돌려줘야 한다.
            if (!check[i]) {
                dfs(i);
                lines++;
            }
        }
        System.out.println(lines);
    }

    static void dfs(int x) { // 하나의 덩어리를 탐색
        check[x] = true;
        for (int next : box[x]) {
            if (!check[next]) {
                dfs(next);
            }
        }
    }

}
