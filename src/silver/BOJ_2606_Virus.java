package silver;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2606_Virus { // 배운 개념은 아니지만 일단 풀어봄 (알고리즘 및 자료구조 강의 개념)

    static boolean[] visited; // 연결 쌍에서 중복된 컴퓨터인지 확인 해주는 장치
    static ArrayList<Integer>[] graph;
    static int count = 0; // 중복이 아니면 (false) 카운트 한다.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int computers = scanner.nextInt();
        int connect = scanner.nextInt();

        graph = new ArrayList[computers+1];
        for (int i = 1; i <= computers; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < connect; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        // 연결 여부 저장하는 배열 생성
        visited = new boolean[computers+1];
        dfs(1);

        System.out.println(count);
    }

    static void dfs(int v) { // v 번 컴퓨터에 연결된 모든 컴퓨터를 체크
        visited[v] = true; // 이건 카운트 하는게 아니라 카운트를 했는지 안했는지 확인 하는 것 (연결 쌍에는 중복이 있으니까)
        for (int next : graph[v]) {
            if (!visited[next]) {
                count++; // 중복이 아닌경우에 카운트 한다.
                dfs(next); // 체크한 그 컴퓨터에 가서 그 컴퓨터에 연결된 것 중에 중복 체크 안된 컴퓨터를 카운트
            }
        }
    }
}
