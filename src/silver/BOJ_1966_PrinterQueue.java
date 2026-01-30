package silver;

import java.util.*;

public class BOJ_1966_PrinterQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        while (tests-- > 0) { // 꺼내서 결국 안에 아무것도 없어질 때까지 반복
            int n = scanner.nextInt();
            int targetIndex = scanner.nextInt();

            PrinterQueue printerQueue = new PrinterQueue();
            for (int i = 0; i < n; i++) {
                int priority = scanner.nextInt();
                printerQueue.add(priority, i == targetIndex); // 'i 가 내가 찾던 문서인지 유무'를 매개변수로 넣음
            }

            System.out.println(printerQueue.printOrderOfTarget());
        }
    }

    static class Document { // 문서의 정보를 관리하는 클래스

        private final int priority;
        private final boolean target;

        public Document(int priority, boolean target) {
            this.priority = priority;
            this.target = target;
        }

        public int getPriority() {
            return priority;
        }

        public boolean isTarget() {
            return target;
        }
    }

    static class PrinterQueue { // 로직 처리 클래스
        private final Deque<Document> deque = new ArrayDeque<>();

        public void add(int priority, boolean isTarget) { // ✅ 문서의 우선순위와 내가 찾던 문서인지는 항상 같이 다녀야 한다 ‼️
            deque.offer(new Document(priority, isTarget)); // 두 정보를 값 하나만 저장하는 큐에 어떻게 저장하지? 가 헷갈렸는데 객체로 하나로 만들어서 저장한다.
        }

        public int printOrderOfTarget() {
            int printCount = 0;

            while (true) {
                if (!deque.isEmpty()) {
                    Document current = deque.poll();

                    if (existHigherPriority(current)) {
                        deque.offer(current); // 우선순위가 아니니까 현재 문서를 맨뒤로 추가 (비교한 맨 앞 문서는 poll 로 꺼내져서 사라짐, 우선순위 아니라 내거인지 체크도 x)
                    } else {
                        printCount++; // 만약 제일 우선순위 문서가 맞다면 꺼내진게 출력되는 거니까 카운트
                        if (current.isTarget()) { // 내가 찾는 문서인지 확인, 맞으면 출력순서를 반환 ‼️
                            return printCount;
                        }
                        // 아니면 다시 while 을 반복
                    }
                }
            }
        }

        private boolean existHigherPriority(Document current) {
            for (Document doc : deque) {
                if (doc.getPriority() > current.getPriority()) { // 큐 안에 현재 문서보다 우선순위가 높은 문서가 있다면
                    return true;
                }
            }
            return false;
        }
    }

}
