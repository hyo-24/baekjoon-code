package silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2667_bowl {

 static int[][] apart;
 static int apartNum;
 static boolean[][] check;
 static int door;


    static void main() {
        Scanner scanner = new Scanner(System.in);

        door = scanner.nextInt();
        apart = new int[door][door];
        apartNum = 0;
        check = new boolean[door][door];

        for (int i = 0; i < door; i++) {
            String line = scanner.next();
            for (int j = 0; j < door; j++) {
                apart[i][j] = line.charAt(j) -'0';
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < door; i++) {
            for (int j = 0; j < door; j++) {
                if (apart[i][j] == 1 && !check[i][j]) {
                    int doors = dfs(i, j);
                    result.add(doors);
                    apartNum++;
                }
            }
        }

        System.out.println(apartNum);
        Collections.sort(result);
        for (Integer i : result) {
            System.out.println(i);
        }


    }

    static int dfs(int x, int y) {
        check[x][y] = true; // 처음 들어와서 본인에 방문 확인!
        int doors = 1; // 부지에 있는 집 개수에 나도 포함시키기

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        for (int i = 0; i < 4; i++) {
            int dirX = x + dx[i];
            int dirY = y +dy[i];
            if (dirX >= 0 && dirX < door && dirY >= 0 && dirY < door) { // 조건 : 좌표를 잘 생각해보면 작성 가능
                if (apart[dirX][dirY] == 1 && !check[dirX][dirY]) {
                    doors += dfs(dirX,dirY);
                    /*  ✅콜 스택 (Call Stack) : += 연산은 dfs 함수가 완전히 끝나서 값을 들고 돌아온 직후에 실행된다.
                    그래서 리턴값을 받기 전에는 계산되지 않고 기다리고 있다가, 마지막 차례가 1을 들고 오기 시작하면 그때부터
                    도미노처럼 촤르륵 더해진다! 쌓여있다가 거꾸로 올라오면서 계산
                     */
                }
            }
        }
        return doors;
    }
}
