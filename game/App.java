package game;

import java.util.Scanner;

public class App {
    public static boolean inputStringCheck(String inputString) {
        inputString = inputString.toLowerCase();

        return inputString.equals("protoss") || inputString.equals("terran") || inputString.equals("zerg");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = null;

        while (true) {
            System.out.print("플레이 하려는 종족을 선택해 주세요(Protoss, Terran, Zerg) : ");
            inputString = scanner.nextLine();
            if (inputStringCheck(inputString)) {
                break;
            }
            System.out.println("Protoss, Terran, Zerg 중에서 입력해주세요. (대소문자 상관 없습니다.)\n");
        }

        Game game = new Game(inputString);

        game.startGame();

        scanner.close();

    }
}
