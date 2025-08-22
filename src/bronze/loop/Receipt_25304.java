package bronze.loop;

import java.util.Scanner;

public class Receipt_25304 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int price = 0;
        int count = 0;
        int priceTotal = 0;

        System.out.print("영수증에 적힌 총 금액을 입력하렴 ^^ : ");
        int total = scanner.nextInt(); // nextInt 는 엔터를 취급하지 않음 하지만 nextLine은 엔터를 받음 그래서 뒤에 입력이 문자열 일때! nextLine 으로 엔터 없에줌.


        System.out.print("물건 몇 종류 샀어? : ");
        int types = scanner.nextInt();


        System.out.println("물건 가격이랑 개수 적어봐 : ");
        for (int i = 0; i < types; i++) {
            price = scanner.nextInt();
            count = scanner.nextInt();
            priceTotal += price*count;
        }

        if (priceTotal == total) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }


    }
}
