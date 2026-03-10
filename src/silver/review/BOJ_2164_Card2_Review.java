package silver.review;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_2164_Card2_Review { // 앞에서 푼 것보다 훨씬 깔끔한 코드 작성했다.

    static void main() {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        Deque<Integer> stack = new ArrayDeque<>(num);

        for (int i = num; i >= 1; i--) { // ✅ 부호 방향 반대 >= 바꾸는 걸 놓침
            stack.offerFirst(i);
            /* ✅ 사실 용량이 정해져있는 컬랙션에서는 offerFirst() 을 사용해야 프로그램을 멈추는 예외처리 보다 false 를 반환해서 더 적절하다.
            반환 타입이 boolean 이지만 모든 메서드는 사용하지 않으면 굳이 반환타입을 받을 필요는 없다. 반드시 필요한 건 해야한다. (값을 꺼내오고 사용안하면 GC 대상됨)
             */

        }

        while (true) {
            if (stack.size() == 1) {
                break;
            }
            stack.pollFirst();
            stack.offerLast(stack.peekFirst());
            stack.pollFirst();
        }
        Integer peek = stack.peek();
        System.out.println(peek);
    }

}
