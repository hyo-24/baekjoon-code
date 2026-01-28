package bronze;

import java.util.Scanner;

public class BOJ_10950_PlusABLoopTest {

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
