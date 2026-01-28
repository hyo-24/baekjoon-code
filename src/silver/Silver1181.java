package silver;

import java.util.Arrays;
import java.util.Scanner;

public class Silver1181 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        scanner.nextLine();

        String[] box = new String[count];

        for (int i = 0; i < count; i++) {
            String letter = scanner.nextLine();
            box[i] = letter;
        }

        Arrays.sort(box, (a,b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        String previous = " ";
        for (String s : box) {
            if (!s.equals(previous)) {
                System.out.println(s);
                previous = s;
            }
        }
    }
}
