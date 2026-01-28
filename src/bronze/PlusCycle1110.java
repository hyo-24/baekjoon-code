package bronze;

import java.util.Scanner;

public class PlusCycle1110 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = scanner.nextInt();
        int current = firstNum;
        int count = 0;

        while (true) {
            String s = String.format("%02d", current);

            int l = s.charAt(0) - '0';
            int r = s.charAt(1) - '0';

            int sum = l + r;
            current = (r*10)+(sum%10);

            count++;

            if (current == firstNum) {
                break;
            }
        }
        System.out.println(count);
    }

}
