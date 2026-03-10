package silver.review;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2606_Virus_Review {
    static ArrayList<Integer>[] link;
    static boolean[] check;
    static int count = 0; // 자기자신도 포함 시키는 건 전체적으로 연결된걸 확인할 때! 지금은 1과 연결된 것만 찾기 때문에 자기자신 포함 x

    static void main() {
        Scanner scanner = new Scanner(System.in);
        int computerNum = scanner.nextInt();
        int linkNum = scanner.nextInt();

        link = new ArrayList[computerNum + 1]; // 배열리스트 초기화도 해야한다 !!!
        for (int i = 1; i <= computerNum; i++) {
            link[i] = new ArrayList<>(); // 안의 리스트 생성 뿐만 아니라 !!
        }
        check = new boolean[computerNum];

        for (int i = 1; i <= linkNum; i++) {
            int com1 = scanner.nextInt();
            int com2 = scanner.nextInt();

            link[com1].add(com2);
        }

        dfs(1);
        System.out.println(count);

    }

    static void dfs(int v) {
       // 종료 조건 안 넣어도 이 로직은 더 할게 없으면 자동으로 종료된다.
        check[v] = true;
        for (Integer i : link[v]) { // 일반 for문 보다 for-each 문이 인덱스 필요 없는 이 로직에 더 맞는다.
            if (!check[i]) {
                count++; // 카운트를 누적하는 건 한 덩어리를 도는 걸 전체적으로 할 경우! 지금은 한 덩어리만 도는 로직이다.
                dfs(i);
            }
        }
    }
}
