package silver;

import java.util.Scanner;

public class BOJ_1436_MovieDirector {

    static void main() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int start = 1;
        String contain = String.valueOf(666);
        int count = 0;

        while (true) {
            String s = String.valueOf(start);
            if (s.contains(contain)) {
                count++;
            }
            // start++; 여기다 했었음 그래서 결과가 1667 이 나옴
            if (count == n) {
                break;
            }
            start++; // ✅ 포함하고 있다는 걸 확인하면 바로 멈춰서 출력해야 함!! 코드 흐름 잘 생각하면서 증감 위치 정하기 ‼️
        }

        System.out.println(start);
    }
}
