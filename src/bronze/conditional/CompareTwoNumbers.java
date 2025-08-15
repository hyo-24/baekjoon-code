package bronze.conditional;

import java.util.Scanner;

public class CompareTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("비교할 숫자를 입력하세요 : ");
        int number1 = scanner.nextInt(); // 입력하는 숫자는 엔터를 치면 밑줄로 내려가서 그냥 바로 숫자를 여러개 입력하면 한 줄에 입력된다!
        int number2 = scanner.nextInt();
        scanner.nextLine();

        if (number1 > number2) {
            System.out.println(">");
        } else if (number1 < number2) {
            System.out.println("<");
        } else {
            System.out.println("==");
        }
    }

}
