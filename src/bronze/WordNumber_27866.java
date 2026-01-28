package bronze;

import java.util.Scanner;

public class WordNumber_27866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String words = scanner.nextLine();
        int number = scanner.nextInt();

        char[] word = words.toCharArray();

        char result = word[number -1];
        System.out.println(result);

    }
}
