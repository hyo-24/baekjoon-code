package bronze.class1.loop;

import java.util.Scanner;

public class M2675 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int R = scanner.nextInt();
            String s = scanner.next(); // next() ➡️입력된 문자열을 공백 기준으로 한 단어씩 읽어오는 메서드 (띄어쓰기하면 바로 입력 종료) <-> nextLine() 은 문장 전체를 입력받음

            StringBuilder sb = new StringBuilder(); // 여러개의 문자를 더할 때 불변객체인 문자열을 가변으로 하는 StringBuilder 사용 (case 마다 초기화)

            for (int k = 0; k < s.length(); k++) { // 문자열의 길이 = 문자열 안의 문자 개수 (자바에서는 String은 내부적으로 char의 묶음이다.)
                char letter = s.charAt(k); // charAt() 은 특정 인덱스의 문자 하나를 반환해주는 메서드이다.
                for (int y = 0; y < R; y++) {
                    sb.append(letter); // append() ➡️ 여러 문자열을 추가한다.
                }
            }
            System.out.println(sb.toString()); //  toString() ➡️ 가변 객체를 다시 불변인 String 타입으로 반환
        }
    }
}
