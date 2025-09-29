package bronze;

import java.util.Scanner;

public class Clock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int H = scanner.nextInt();
        int M = scanner.nextInt();

        if (0 < H && H <= 24) {
            if (M >= 45) {
                M = M - 45;
                System.out.println(H+" "+M);
            } else {
                H = H -1;
                M = M + 60 - 45;
                System.out.println(H+" "+M);
            }
        } else if (0 == H) {
            if (M >= 45) {
                M = M - 45;
                System.out.println(H+" "+M);
            } else {
                H = H + 23;
                M = M + 60 - 45;
                System.out.println(H+" "+M);
            }
        }


    }
}
