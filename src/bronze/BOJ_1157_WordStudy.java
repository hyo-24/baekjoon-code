package bronze;

import java.util.*;

public class BOJ_1157_WordStudy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character,Integer> alphabets = new HashMap<>();
        String word = scanner.next().toUpperCase(); // ✅ 자바는 문자열/문자 처리 기본값이 대소문자를 구분하기 때문에 무조건 입력받을 때 통일 필요

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            alphabets.put(c, alphabets.getOrDefault(c, 0) + 1);
        }

        // value 의 최댓값
        Integer max = Collections.max(alphabets.values());
        int maxCount = 0;
        char result = '?'; // ✅ 초기화 반드시 필요! 문자로 아무거나 작은 따옴표로 설정

        Set<Map.Entry<Character, Integer>> entrySet = alphabets.entrySet();
        for (Map.Entry<Character, Integer> entry : alphabets.entrySet()) { // ✅ entry 가져와서 바로 getValue() 가 아니라 반복문으로 만들어서 호출하기
            if (entry.getValue().equals(max)) {
                maxCount++;
                result = entry.getKey();
            }
        }

        if (maxCount == 1) {
            System.out.println(result);
        } else {
            System.out.println("?");
        }
    }
}
