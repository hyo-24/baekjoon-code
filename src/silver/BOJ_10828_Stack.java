package silver;

import java.util.*;

public class BOJ_10828_Stack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyStack myStack = new MyStack();
        int orders = scanner.nextInt();

        for (int i = 0; i < orders; i++) {
            String order = scanner.next();

            switch (order) {
                case "push" :
                    int x = scanner.nextInt();
                    myStack.push(x);
                    break;

                case "pop":
                    System.out.println(myStack.pop());
                    break;

                case "size":
                    System.out.println(myStack.size());
                    break;

                case "empty":
                    System.out.println(myStack.empty());
                    break;

                case "top":
                    System.out.println(myStack.top());
                    break;
            }
        }


    }

    static class MyStack {

        Deque<Integer> deque = new ArrayDeque<>();

        void push(int x) {
            deque.push(x);
        }

        int pop() {
            if (deque.isEmpty()) {
                return -1;
            }
            return deque.pop();
        }

        int size() {
            return deque.size();
        }

        int empty() {
            return deque.isEmpty() ? 1 : 0;
        }

        private int top() {
            return deque.isEmpty() ? -1 : deque.peek();
        }
    }
}
