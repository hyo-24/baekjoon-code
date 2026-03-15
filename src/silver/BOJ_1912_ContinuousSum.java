package silver;


import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1912_ContinuousSum {

    static int sum;
    static int numbers;
    static  ArrayList<Integer> list;

    static void main() {
        Scanner scanner = new Scanner(System.in);

        numbers = scanner.nextInt();
        list = new ArrayList<>(numbers);


        for (int i = 0; i < numbers; i++) {
            list.add(scanner.nextInt());
        }


    }

    static void find() {

        int[] dr = {-1, 1};

        for (int i = 0; i < 2; i++) {
            int i1 = dr[i];
            for (int j = 0; j < numbers; j++) {

            }
        }
    }

}
