package bronze.advanced;

import java.util.Scanner;

public class Chess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] standard = {1,1,2,2,2,8}; // 정해진 수들을 배열에 넣어둠
        StringBuilder sb = new StringBuilder(); // 계산한 수들을 한번에 출력하려고 append() 를 써서 (없어도 가능)

        for (int i = 0; i < 6; i++) {
            int have = scanner.nextInt(); // 이 입력받는 부분은 이렇게 해도 되고 배열에 넣어서 해도 된다. (배열에 넣으면 나중에 재사용이 용이)
            sb.append(standard[i]- have); // 이 부분이 핵심!!! 배열에 넣은 수를 하나씩 꺼내서 입력받은 수를 뺀다.
            if (i < 5) sb.append(' ');
        }
        System.out.println(sb);
    }
}
