package silver;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_2164_Card2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cardNum = scanner.nextInt();
        FindCard card = new FindCard();

        for (int i = 1; i <= cardNum; i++) {
            card.add(i);
        }

        card.find();

    }

    static class FindCard {

        Deque<Integer> deque = new ArrayDeque<>();

        void add(int card) {
            deque.offerLast(card);
        }

        void find() {

            while (deque.size() > 1) {
                deque.pollFirst();
                deque.offerLast(deque.pollFirst());
            }

            System.out.println(deque.peek());
        }


    }
}
