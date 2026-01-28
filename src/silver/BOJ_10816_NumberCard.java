package silver;

import java.util.*;

public class BOJ_10816_NumberCard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cards = scanner.nextInt();
        Map<Integer,Integer> deck = new HashMap<>();

        for (int i = 0; i < cards; i++) {
            int num = scanner.nextInt();
            deck.put(num, deck.getOrDefault(num, 0) + 1);
        }

        int figureCards = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < figureCards; i++) {
            int query = scanner.nextInt();
            sb.append(deck.getOrDefault(query, 0)).append(" ");
        }

        System.out.println(sb.toString().trim());

        /* 카드에 숫자 생성
        System.out.println("카드의 숫자를 지정하시오");
        for (int i = 0; i < cards; i++) {
            deck.put(i,scanner.nextInt());
        }

        // 찾으려는 숫자와 개수 입력, 답지 생성
        System.out.println("찾으려는 수의 개수를 입력하시오");
        int figureCards = scanner.nextInt();
        Map<Integer,Integer> figureNum = new HashMap<>(figureCards);

        System.out.println("찾으려는 숫자를 입력하시오");
        for (int i = 0; i < figureCards; i++) {
            figureNum.put(i,scanner.nextInt());
        }

        // 정답 저장 리스트
        List<Integer> result = new ArrayList<>(figureCards);

        // 카드 순회
        Iterator<Integer> iterator = figureNum.keySet().iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            int count = 0;
            for (Integer i : deck.values()) {
                if (i.equals(value)) {
                    ++count;
                }
            }
            result.add(count);
        }
        System.out.println("결과: "+result);*/
    }
}
