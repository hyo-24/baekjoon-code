package silver;

import java.util.*;

public class BOJ_1991_TreeIterator { // 가장 콜 스택(Call Stack) 을 잘 보여주는 방식 --> 트리 구조

    static Map<String,String[]> map;

    static void main() {
        Scanner scanner = new Scanner(System.in);
        map = new HashMap<>();

        int trees = scanner.nextInt();

        for (int i = 0; i < trees; i++) {
            String key = scanner.next();
            String value1 = scanner.next();
            String value2 = scanner.next();
            map.put(key,new String[]{value1,value2});
        }


        meFirst("A");
        System.out.println();
        meMid("A");
        System.out.println();
        meLast("A");
        System.out.println();

    }

    static void meFirst(String current) {
        if (current.equals(".")) {
            return;
        }
        System.out.print(current);
        meFirst(map.get(current)[0]);
        meFirst(map.get(current)[1]);
    }

    static void meMid(String current) {
        if (current.equals(".")) {
            return;
        }
        meMid(map.get(current)[0]);
        System.out.print(current);
        meMid(map.get(current)[1]);

    }

    static void meLast(String current) {
        if (current.equals(".")) {
            return;
        }
        meLast(map.get(current)[0]);
        meLast(map.get(current)[1]);
        System.out.print(current);

    }
}
