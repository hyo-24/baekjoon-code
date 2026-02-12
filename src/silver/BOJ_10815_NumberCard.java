package silver;

import java.util.*;

public class BOJ_10815_NumberCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = scanner.nextInt();
        Set<Integer> cards = new HashSet<>(numbers);

        for (int i = 0; i < numbers; i++) {
            cards.add(scanner.nextInt());
        }

        int matchNumbers = scanner.nextInt();
        StringBuilder sb = new StringBuilder(); // 백준은 출력 형태가 중요하다! 리스트로 출력되면 성공 못함.


        for (int i = 0; i < matchNumbers; i++) {
            int number = scanner.nextInt();
            if (cards.contains(number)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb.toString().trim()); // trim() 은 앞,뒤 공백을 제거한다.


        /*
        map.put(key, getOrDefault(key,0)+1) 는 각 숫자의 중복 개수를 구할 때 사용한다.
        같은게 있으면 +1
        그런데 기존에 중복 카운트를 했던 숫자면 있던 개수에 증감, 없으면 새로 생성해서 0 +1 = 1 이 설정된다.

         */
    }


}
