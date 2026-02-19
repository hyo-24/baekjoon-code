package silver;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2606_Virus { // 배운 개념은 아니지만 일단 풀어봄 (알고리즘 및 자료구조 강의 개념)

    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int count = 0;

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

        visited = new boolean[computers+1];
        dfs(1);

        System.out.println(count);
    }

    static void dfs(int v) {
        visited[v] = true;
        for (int next : graph[v]) {
            if (!visited[next]) {
                count++;
                dfs(next);
            }
        }
    }
}
