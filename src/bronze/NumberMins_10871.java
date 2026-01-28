package bronze;

import java.util.Scanner;

public class NumberMins_10871 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCount = scanner.nextInt();
        int standard = scanner.nextInt();

        int[] array = new int[numCount];

        for (int i = 0; i < numCount; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i : array) {
            if (i < standard) {
                System.out.print(i+" ");
            }
        }
    }
}
