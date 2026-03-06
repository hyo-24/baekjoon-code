package silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2583_Domain {

    static int[][] coordinate;
    static boolean[][] check;
    static ArrayList<Integer> wide;
    static int width, height, rectangle;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void main() {
        Scanner scanner = new Scanner(System.in);

        height = scanner.nextInt(); // ✅ 문제 순서 체크 잘하기
        width = scanner.nextInt();

        coordinate = new int[width][height];
        check = new boolean[width][height];
        wide = new ArrayList<>();

        rectangle = scanner.nextInt();


        for (int i = 0; i < rectangle; i++) {
            int leftX = scanner.nextInt();
            int leftY = scanner.nextInt();
            int rightX = scanner.nextInt();
            int rightY = scanner.nextInt();

            // 직사각형 공간에 1 넣기
            for (int j = leftX; j <= rightX; j++) {
                for (int k = leftY; k <= rightY; k++) { // ✅오른쪽 y절편이 더 크다
                    coordinate[j][k] = 1;
                }
            }
        }

        // 빈 공간 찾기
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (coordinate[i][j] != 1 && !check[i][j]) {
                    wide.add(dfs(i, j));
                }
            }
        }

        // 정답 출력
        System.out.println(wide.size());
        Collections.sort(wide); // ✅ 오름차순 정렬하라는 부분 못 읽음
        for (Integer i : wide) {
            System.out.println(i);
        }
    }

    static int dfs(int x, int y) {
        check[x][y] = true;
        int wide = 1; // ✅ 자기자신을 꼭 포함한 채로 시작하기

        for (int i = 0; i < 4; i++) {
            int fx = x + dx[i];
            int fy = y + dy[i];
            if (fx >= 0 && fx < width && fy >= 0 && fy < height) {
                if (coordinate[fx][fy] != 1 && !check[fx][fy]) {
                    wide += dfs(fx, fy); // ✅ 데이터 누적 익히기
                }
            }
        }
        return wide; // ✅ 넓이는 해당하는 배열의 수를 구하면 된다. 좌표로 계산하는게 아니다!
    }
}
