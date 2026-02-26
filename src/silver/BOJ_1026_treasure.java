package silver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1026_treasure {

    static void main() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
         int[] a = new int[n];
         Integer[] b = new Integer[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        Arrays.sort(a);

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += a[i] * b[i];
        }

        System.out.println(total);

    }

}
