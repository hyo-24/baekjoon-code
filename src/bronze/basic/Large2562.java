package bronze.basic;

import java.util.Scanner;

public class Large2562 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] large = new int[9]; // 인덱스는 0부터 8까지임

        for (int i= 0; i < large.length; i++) {
            large[i] = scanner.nextInt();
        }

        int o = 0;
        for (int i = 0; i < large.length; i++) {
            if (o < large[i]) { // o 의 값이 초기화되면 안된다.
                o = large[i];
            }
        }
        int num = 0;
        for (int i = 0; i < large.length; i++) { // 최댓값이 몇 번째 배열에 있는지
            if (o == large[i]) {
                num = i +1;
            }
        }
        System.out.println("최댓값은 "+o);
        System.out.println(num);
    }
}
// 향상된 for 문은 배열의 인덱스가 아닌 배열의 초기화값(전부 0)이 계속 i에 들어갑니다.
//배열에 값을 초기화(저장)할 때는 인덱스가 필요하기 때문에 향상된 for문(for-each)**을 사용하면 안 됩니다.
//향상된 for 문은 배열의 모든 요소를 순회하며 읽어오기 위해 만들어진 문법입니다.
