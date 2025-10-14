package bronze.basic;

import java.util.Scanner;

public class AB10950 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loop = scanner.nextInt();

        for (int i = 0; i < loop; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            int sum = A + B;
            System.out.println(sum);
        }
    }
}
