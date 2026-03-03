package silver;

import java.util.Scanner;

public class BOJ_1012_Organic {

    static int width;
    static int height;
    static int bugs;
    static int[][] ground;
    static boolean[][] check;

    static void main() {
        Scanner scanner = new Scanner(System.in);

        int testCount = scanner.nextInt();
        int count = 0;

        while (true) {

            if (count == testCount) {
                break;
            }

            width = scanner.nextInt();
            height = scanner.nextInt();
            int cabbages = scanner.nextInt();

            ground = new int[width][height];
            check = new boolean[width][height];
            bugs = 0;

            for (int i = 0; i < cabbages; i++) {
                int w = scanner.nextInt();
                int h = scanner.nextInt();

                ground[w][h] = 1;
            }

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (ground[i][j] == 1 && !check[i][j]) { // 본인 확인
                        dfs(i,j);
                        bugs++; // 한 위치에 연결된 덩어리 다 확인 후 벌레 증감
                    }
                }
            }
            System.out.println(bugs);
            count++;
        }

    }

    static void dfs(int x, int y) {

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        check[x][y] = true;

        for (int i = 0; i < 4; i++) { // 주변 다 확인하기 (끝나면 다시 위로 올라가 bug++)
            int wid = x + dx[i];
            int hei = y + dy[i];
            if (wid >= 0 && wid < width && hei >= 0 && hei < height) {
                if (ground[wid][hei] == 1 && !check[wid][hei]) { // 체크하는 주변 확인
                    dfs(wid, hei); // 연결된 덩어리 전부 방문
                }
            }
        }
    }
}
