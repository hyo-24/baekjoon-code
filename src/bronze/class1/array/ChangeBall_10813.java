package bronze.class1.array;

import java.util.Scanner;

public class ChangeBall_10813 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] boxes = new int[N + 1];

        for (int i = 1; i <= N; i++) {
           boxes[i] = i;
        }

        for (int o = 0; o < M; o++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
                int tmp = boxes[i]; // 배열값 저장으로 지역변수를 사용
                boxes[i] = boxes[j];
                boxes[j] = tmp;
        }// 값 바꿀 때 임시 공간 하나 만들어 쓰는 패턴(swap) 맞아요.
        //보통은 배열의 첫 번째 칸을 “임시 저장소”처럼 쓰기도 하는데, 그건 좋은 습관은 아니에요.
        // 	배열의 0번 칸도 실제 데이터니까, 거기다 덮어쓰면 원래 있던 값이 날아가 버려요.
        //	그래서 나중에 출력하면 0번 값까지 같이 출력돼서 문제 틀리기 쉽죠. 그래서 그냥 지역변수를 하나 설정해서 그걸 쓰는 게 나음


        for (int i = 1; i <= N; i++) {
            if (i == N) { // 마지막 원소라면
                System.out.print(boxes[i]);
            } else {
                System.out.print(boxes[i] + " ");
            }
        }

    }
}
