package bronze;

import java.util.Scanner;

public class LargeMin10818 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int[] numbers = new int[num];

        for (int i = 0; i < numbers.length; i++) { // 입력받을 때 인덱스 0 에도 값을 받아야 한다! 받은 값으로 비교하는 것
            int n = scanner.nextInt();
            numbers[i] = n;
        }

        int large = numbers[0]; // number[0] 에 최댓값, 최솟값을 다 저장하는게 아니라!! number[0] 의 값을 int large, min 변수에 초기값으로 설정하는 것이다.
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > large) {
                large = numbers[i];
            }
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        System.out.println(min+" "+large);

    }
}
