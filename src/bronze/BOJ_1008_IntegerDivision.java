package bronze;

import java.util.Scanner;

public class BOJ_1008_IntegerDivision {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        double result = (double) A / B;

        System.out.println(result);

    }
}
