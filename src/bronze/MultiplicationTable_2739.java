package bronze;

import java.util.Scanner;

public class MultiplicationTable_2739 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int multiNum = scanner.nextInt();

        if (multiNum >= 1 && multiNum <= 9) {
            for (int i = 1; i < 10; i++) {
                int result = multiNum * i;
                System.out.println(multiNum + " * " + i + " = " + result);
            }
        }
    }
}
