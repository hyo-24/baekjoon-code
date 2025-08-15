package bronze.array;

import java.util.Scanner;

public class Count10807 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력할 숫자의 개수를 입력하세요 : ");
        int num = scanner.nextInt();
        int[] numbers = new int[num];

        if (num >= 1 && num <= 100) { // 이 조건문을 어디까지 포함해야하는지 헷갈렸다. 다 포함해야함.
            for (int i = 0; i < num; i++) { // 인덱스는 0 부터 시작해서 범위를 <= 로 하면 안된다.
                int findNum = scanner.nextInt();
                numbers[i] = findNum;

            }
            System.out.print("찾을 숫자 : ");
            int v = scanner.nextInt();
            int count = 0; // 입력받은 숫자의 개수를 담는 count 변수를 어디에 선언해야 하는지를 헷갈렸다.

            for (int number : numbers) {
                if (number == v) { // 같은 걸 조건으로 할 때 기본형 변수라 == 으로 가능
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
