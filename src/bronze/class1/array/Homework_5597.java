package bronze.class1.array;

import java.util.Scanner;

public class Homework_5597 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 이 문제의 요지는 제출한 번호를 표시(mark)하고 표시 되지 않은 두 개를 출력하는 것.

        boolean[] submitted = new boolean[31]; // 0 은 미사용

        for (int i = 0; i < 28; i++) {
            int studentsNum = scanner.nextInt();
            if (1 <= studentsNum && studentsNum <= 30) {
                submitted[studentsNum] = true; // 제출 학생 표시
            }
        }

        for (int i = 1; i <= 30; i++) {
            if (!submitted[i]) { // true가 아닌 숫자를 출력
                System.out.println(i);
            }
        }

    }
}
