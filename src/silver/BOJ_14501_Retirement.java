package silver;

import java.util.*;

public class BOJ_14501_Retirement {

    static class Counsel {
        private final int time;
        private final int price;

        public Counsel(int time, int price) {
            this.time = time;
            this.price = price;
        }

        public int getTime() {
            return time;
        }


        public int getPrice() {
            return price;
        }

    }
    static int days;
    static int[] dp;
    static Counsel[] schedule;

    static void main() {
        Scanner scanner = new Scanner(System.in);

        days = scanner.nextInt();
        schedule = new Counsel[days + 2];
        dp = new int[days + 2];

        for (int i = 1; i <= days; i++) {
            int time = scanner.nextInt();
            int price = scanner.nextInt();

            Counsel counsel = new Counsel(time, price);
            schedule[i] = counsel;
        }

        int calculate = calculate();
        System.out.println(calculate);

    }

    static int calculate() {

        for (int i = days; i >= 1; i--) {
            int nextDay = schedule[i].getTime() + i;

            if (nextDay <= days + 1) { // 7일차에 1일 걸리는 상담 포함하기 위해서
                dp[i] = Math.max(schedule[i].getPrice() + dp[nextDay],dp[i + 1]);
            } else {
                dp[i] = dp[i + 1]; // i + days 가 아니다.
            }
        }
        return dp[1];
    }



        /*int days = scanner.nextInt();
        Map<Integer,Integer> schedule = new LinkedHashMap<>(days+1);

        for (int i = 1; i <= days; i++) {
            int day = scanner.nextInt();
            int money = scanner.nextInt();
            schedule.put(day,money);
        }

        // 2일차에서부터 key 에 1씩 증감하면서 더하고 7이 넘으면 제외
        // 값 나누기 키 해서 오름차순 정렬

        int plusDay = 0;
        ArrayList<Integer> availableKey = new ArrayList<>();
        for (Integer i : schedule.keySet()) {
            if (i + plusDay < 7) {
                availableKey.add(i);
            }
        }

        ArrayList<Integer> findBest = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            if (availableKey.contains(entry.getKey())) {
                Integer value = entry.getValue();
                Integer key = entry.getKey();
                int bestMoney = value / key;
                findBest.add(bestMoney);
            }
        }

        int totalMoney = 0;
        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            for (Integer i : findBest) {
                if (entry.getKey().equals(i)) {
                    totalMoney += entry.getValue();
                }
            }
        }

        System.out.println(totalMoney);*/

}
