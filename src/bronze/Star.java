package bronze;

import java.util.Scanner;

public class Star {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int star = scanner.nextInt();

        // 삼각형 별 = 핵심은 줄 번호 만큼 별을 찍게 만드는 것 (j <= i)
         for (int i = 1; i <= star; i++) { // 현재 줄
            for (int j = 1; j <= i; j++) { // 별 개수
                System.out.print("*");
            }
            System.out.println();
        }

        // 피라미드 별 = 삼각형인데 가운데 정렬이 돼 있다. 왼쪽에 먼저 공백을 찍어주고 다음에 별이 연속적으로 나오며 줄이 내려갈수록 빈칸이 줄고 별은 증가한다.
        /*for (int i = 1; i <= star; i++) { // ➡️ 줄 번호
            for (int j = 1; j <= star - i; j++) { // ➡️ j 는 빈칸 개수
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }*/
    }
}
