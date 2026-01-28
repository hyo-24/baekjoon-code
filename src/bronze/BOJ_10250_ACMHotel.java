package bronze;

import java.util.Scanner;

public class BOJ_10250_ACMHotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int test = scanner.nextInt();

        for (int i = 0; i < test; i++) { // 101호 부터 HW 호까지 차례대로 손님이 들어간다.
            int H = scanner.nextInt(); // 6층
            int W = scanner.nextInt(); // 8개
            int N = scanner.nextInt(); // 13번째 손님 -> 나누기를 하면 호실 번호가 나온다. 그리고 딱 떨어지면 마지막 층이다.

           int floor = N % H;
            if (floor == 0) {
                floor = H;
            }

           int room = (N -1) / H +1;
           /* 예시: H = 6, N = 6
	       ➡️ 손님은 사실 6층 1호실에 들어가야 한다. 그런데 N / H = 6 / 6 = 1 → 이걸 “호실 번호”라고 쓰면 호실이 넘어가 2호실로 계산되어버림 ❌
	       나누기는 같은 수일때, 위치를 말해주는게 아니라 몇 개가 꽉 찼는지(=양) 를 알려주는 값이라서 헷갈리는 것!
	       그래서 꽉 찼을 때 증가되서 -1 을 하면 양을 위치로 바꿀 수 있다.
           */
            System.out.println(floor*100+room);

        }




    }
}
