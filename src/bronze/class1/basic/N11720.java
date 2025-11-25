package bronze.class1.basic;

import java.util.Scanner;

public class N11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        String num = scanner.next();

        int sum = 0;

        for (int i = 0; i < N; i++) {
            char digitChar = num.charAt(i);
            int value = digitChar - '0'; // 문자열을 하나씩 나누고 가져와서 아스키코드를 이용해 int 로 만들고 누적한다.
            sum+= value;
        }

        System.out.println(sum);
    }
}
