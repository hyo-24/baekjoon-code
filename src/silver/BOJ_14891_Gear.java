package silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_14891_Gear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 띄어쓰기, 엔터, 탭 모두 똑같이 인식해 한줄에 입력해도 여러값 인식 가능

        // 톱니바퀴 관리자 생성
        GearController controller = new GearController();

        // 톱니바퀴에 극단 세팅
        List<List<Integer>> totalGear = new ArrayList<>(5);
        // ✅ for문 의 시작점(i=1)과 리스트 인덱스는 별개다 ‼️리스트의 add()는 현재 리스트의 맨 마지막 빈칸에 데이터를 넣음
        for (int i = 1; i <= 4; i++) {
            System.out.println("4개의 기어에 값을 입력합니다.");
            String line = scanner.next();
            List<Integer> inputPolarity = new ArrayList<>();

            System.out.println("8개의 극단 상태를 입력하시오");
            for (int j = 0; j < 8; j++) {
                inputPolarity.add(line.charAt(j)-'0');
                /* '0' 는 아스키코드를 이용한 것. chatAt(j)는 문자 형태로 극단 상태 0,1이 나옴.
                자바는 문자형 숫자끼리 산술연산을 아스키 코드 값으로 한다. 왜냐면 컴퓨터에는 아스키 코드 값으로 문자형 숫자가 저장되기 때문.
                코드 값도 연속적이라서 서로 빼면 실제 정수형 값이 나온다. '1' (49) - '0' (48) = 1 이렇게 int 값이 반환되게 된다.
                */
            }
            totalGear.add(inputPolarity);
        }
        controller.input(totalGear);

        // 바퀴를 몇번 돌리며, 몇번쨰 바퀴를 어느방향으로 돌릴 건지 입력
        int turns = scanner.nextInt();
        for (int i = 0; i < turns; i++) {
            int gearNum = scanner.nextInt();
            int direction = scanner.nextInt();
            controller.order(gearNum,direction);
        }

        // 점수 계산
        int totalScore = 0;
        if (controller.gears.get(1).figureOut(0)==1) totalScore += 1;
        if (controller.gears.get(2).figureOut(0)==1) totalScore += 2;
        if (controller.gears.get(3).figureOut(0)==1) totalScore += 4;
        if (controller.gears.get(4).figureOut(0)==1) totalScore += 8;

        System.out.println(totalScore);


    }

    static class Gear { // 8개의 극성, 시키는대로 회전 ( ✅핵심 : 바퀴하나가 돌아선 후에 서로의 영향은 생각하지 않음, 딱 돌리는 그 순간의 반응에 대한 결과를 물어보는 것 / 트렌젝션..?)

        List<Integer> gear = new ArrayList<>(8);

        public void add(int x) {
            gear.add(x);
        }

        // 톱니바퀴 회전하기
        public void turn(int direction) { // ✅remove 에서 get 으로 가져오면 해당 인덱스의 값을 지우는게 아니라 그 값의 숫자와 같은 인덱스의 값을 지움
            if (direction == 1) {
                gear.addFirst(gear.getLast());
                gear.removeLast();
            } else if (direction == -1) {
                gear.addLast(gear.getFirst());
                gear.removeFirst();
            }
        }

        // 현재 내 2,6 번째 극단 상태
        public int figureOut(int index) {
           return gear.get(index);
        }

        }



    static class GearController { // 4개 기어 관리(생성, 값 전달받고 세팅), 어떤바퀴가 연쇄적으로 돌아야하나 판단, 기어에 회전명령 내리기

        List<Gear> gears = new ArrayList<>(5);

        // 생성자
        public GearController() {
            for (int i = 0; i <= 4; i++) {
                gears.add(new Gear());
            }
        }

        // 4개의 기어에 값을 다 세팅
        public void input(List<List<Integer>> totalGear) {
            for (int i = 1; i <= 4; i++) {
                // totalGear 는 0,1,2,3번 인덱스에 데이터가 있음
                List<Integer> oneGearData = totalGear.get(i-1);
                for (Integer datum : oneGearData) {
                    gears.get(i).add(datum);
                }
            }
        }

        // 턴 회수, 어떤 기어, 어느 방향 명령 받아오기
        public void order(int gearNum, int direction) {
            processRotation(gearNum,direction);// 상태변경의 원자성을 확보하는 설계....?(판단과 실행을 섞지 않음)
        }

        // 연쇄 반응 판단 및 전체 회전 수행
        private void processRotation(int startGearNum, int startDirection) {
            // 이번 턴에 각 기어가 돌 방향 저장할 장부를 만드는 과정임 ‼️
            int[] direction = new int[5];
            direction[startGearNum] = startDirection; // 먼저 지정받은 기어 먼저 방향 저장

            // 나를 기준으로 왼쪽을 하나씩 검사
            for (int i = startGearNum; i > 1; i--) {
                if (gears.get(i).figureOut(6) != gears.get(i - 1).figureOut(2)) { // 마주보는 극단이 다르면
                    direction[i - 1] = -direction[i];
                } else break;
            }

            for (int i = startGearNum; i < 4; i++) {
                if (gears.get(i).figureOut(2) != gears.get(i + 1).figureOut(6)) { // 마주보는 극단이 다르면
                    direction[i + 1] = -direction[i];
                } else break;
            }

            // 최종 실행 (장부대로 다같이 돌기)
            for (int i = 1; i <= 4; i++) {
                if (direction[i] != 0) gears.get(i).turn(direction[i]);
            }
        }


    }
}
