package silver;

import java.util.*;

public class StringSet14425 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 비교군과 비교대상 입력
        int sizeS = scanner.nextInt();
        int sizeM = scanner.nextInt();
        Set<String> S = new HashSet<>(sizeS);
        List<String> M = new ArrayList<>(sizeM); // ✅ M은 중복이 가능해서 List로 설정했다

        System.out.println("집합 S 의 문자열들을 입력하시오");
        for (int i = 0; i < sizeS; i++) {
            String word = scanner.next();
            S.add(word);
        }

        System.out.println("집합 M 의 문자열들을 입력하시오");
        for (int i = 0; i < sizeM; i++) {
            String word = scanner.next();
            M.add(word);
        }

        int count = 0;
        for (String string : M) {
            if (S.contains(string)) {
                count++;
            }
        }

        System.out.println(count);


    }
}
