package bronze;

import java.util.Scanner;

public class BOJ_11650_Askicode {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char s = scanner.next().charAt(0);
        System.out.println((int) s);

        /*String c = scanner.nextLine(); ➡️ 문자열 전체를 int로 바꿀 수는 없다. charAt() 으로 문자 하나만 가능하다.
        System.out.println((int) c); char 은 int 보다 표현 범위가 작기 때문에 명시적으로 캐스팅하지 않아도 된다.*/
    }
}
