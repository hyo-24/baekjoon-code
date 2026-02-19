package silver;

import java.util.*;

public class BOJ_11652_Card {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cards = scanner.nextInt();

        Map<Long,Integer> result = new HashMap<>();

        for (int i = 0; i < cards; i++) {
            Long card = scanner.nextLong();
            result.put(card, result.getOrDefault(card,0)+1);
        }

        // 현재 1등의 점수(카드 개수)
        int maxCount = -1;
        // 현재 1등의 이름(Long)
        long answer = 0;

        for (Map.Entry<Long, Integer> entry : result.entrySet()) { // 둘 다 필요하면 entry 가 훨씬 성능에 좋다.
            long currentCard = entry.getKey();
            int currentAnswer = entry.getValue();

            if (entry.getValue() > maxCount) {
                maxCount = currentAnswer;
                answer =  currentCard;
            } else if (currentAnswer == maxCount) { // 가장 많은 카드개수가 겹친다면 카드 숫자가 더 작은 게 이김
                if (currentCard < answer) {
                    answer = currentCard;
                }
            }
        }

        System.out.println(answer);

    }
}
