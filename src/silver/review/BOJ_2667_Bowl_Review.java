package silver.review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2667_Bowl_Review {

    static int[][] apart;
    static boolean[][] check;
    static int apartments;
    static int square;

    static void main() {
        Scanner scanner = new Scanner(System.in);

        square = scanner.nextInt();
        apart = new int[square][square];
        check = new boolean[square][square];
        apartments = 0;

        for (int i = 0; i < square; i++) {
            String live = scanner.next();
            for (int j = 0; j < square; j++) {
                apart[i][j] = live.charAt(j) - '0'; // ✅ 0을 빼줘야 1아니면 0 으로 만들어진다.
            }
        }

        ArrayList<Integer> result = new ArrayList<>(); // 단지 내 가구 수
        for (int i = 0; i < square; i++) {
            for (int j = 0; j < square; j++) {
                if (!check[i][j] && apart[i][j] == 1) { // ✅ 여기에도 1인지 확인해야한다. 없는 곳 기준으로 돌 필요 없음
                    result.add(dfs(i, j));
                    apartments++; // 아파트 동 개수
                }
            }
        }

        System.out.println(apartments); // ✅ 아파트 동 개수도 출력해야지?
        Collections.sort(result); // ✅ 문제 제대로 읽어라 오름차순 정렬 필요
        for (Integer i : result) {
            System.out.println(i);
        }

    }

    static int dfs(int x, int y) {
        // 한 덩어리 돌건데 지금 위치에서 다음으로 어떻게 넘어가지? x + 1...? ==> 동서남북 이 한 덩어리를 찾는 방법!!
        check[x][y] = true;
        int house = 1;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int fx = x +dx[i];
            int fy = y + dy[i];

            for (int j = 0; j < square; j++) {
                for (int k = 0; k < square; k++) {
                    if (fx > 0 && fx < square && fy > 0 && fy < square) {
                        if (!check[fx][fy] && apart[fx][fy] == 1) {
                            house += dfs(fx, fy);
                        }
                    }
                }
            }
        }
        return house;
    }
}
