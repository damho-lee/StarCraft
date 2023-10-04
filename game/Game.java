package game;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player;
    private Player computer;
    private Scanner scanner = new Scanner(System.in);
    private Random r = new Random();

    public Game(String userRace) {
        player = new Player("아군", userRace);
        createComputerRace();
    }

    private void createComputerRace() {
        int random = ((int) Math.random()) * 3;
        String computerRace = null;

        switch (random) {
            case 0:
                computerRace = "protoss";
                break;
            case 1:
                computerRace = "terran";
                break;
            case 2:
                computerRace = "zerg";
                break;
            default:
                throw new IllegalArgumentException("createComputerRace의 random 변수가 잘못 설정되어있습니다.");
        }

        computer = new Player("적군", computerRace);
    }

    public void printUnits() {
        System.out.println(computer.getName() + ": " + computer.getRace());
        computer.printPlayerUnits();
        System.out.println();
        System.out.println(player.getName() + ": " + player.getRace());
        player.printPlayerUnits();

    }

    public void startGame() {
        while (true) {
            playerTurn();
            if (gameEnd(player, computer)) {
                printUnits();
                System.out.println("player가 이겼습니다!!!");
                return;
            }

            computerTurn();
            if (gameEnd(computer, player)) {
                printUnits();
                System.out.println("컴퓨터가 이겼습니다!!!");
                return;
            }
        }
    }

    private boolean gameEnd(Player prev, Player next) {
        if (next.numberOfUnits() == 0) {
            return true;
        } else if (prev.isAllCanFly() && next.isAllCanNotFly()) {
            return true;
        } else {
            return false;
        }
    }

    private void playerTurn() {
        printUnits();
        String inputString = null;
        int[] attackAndTargetUnit;
        while (true) {
            try {
                System.out.println(
                        "공격을 수행할 아군 유닛과 공격할 적군 유닛을 선택하세요(아군, 적군 순으로 띄어쓰기로 구분해서 번호를 입력해주세요.\n차례를 넘기거나 공격할 수 있는 대상이 없으면 enter를 쳐주세요.): ");
                inputString = scanner.nextLine();
                if (inputString.isEmpty()) {
                    break;
                }
                attackAndTargetUnit = makeAttackAndTargetUnit(inputString);
                if (player.attack(attackAndTargetUnit[0], computer.getUnit(attackAndTargetUnit[1]))) {
                    computer.remove(attackAndTargetUnit[1]);
                }
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void computerTurn() {
        int attackUnitIndex = -1;
        int targetUnitIndex = -1;
        while (true) {
            try {
                attackUnitIndex = (int) (Math.random() * computer.numberOfUnits());
                targetUnitIndex = (int) (Math.random() * player.numberOfUnits());
                // attackUnitIndex = r.nextInt(computer.numberOfUnits());
                // targetUnitIndex = r.nextInt(player.numberOfUnits());
                System.out.println("attackUnitIndex : " + attackUnitIndex + "\ntargetUnitIndex : " + targetUnitIndex);
                if (computer.attack(attackUnitIndex, player.getUnit(targetUnitIndex))) {
                    System.out.println("\n컴퓨터의 " + computer.getUnit(attackUnitIndex).getName() +
                            "가 플레이어의 " + player.getUnit(targetUnitIndex).getName() + "을 공격했습니다.\n");
                    player.remove(targetUnitIndex);
                }
                break;
            } catch (IllegalArgumentException exception) {
                exception.getMessage();
            }
        }

    }

    private int[] makeAttackAndTargetUnit(String inputString) {
        int[] arr = new int[2];
        inputString = inputString.trim();

        if (!isValidInput(inputString)) {
            throw new IllegalArgumentException("숫자 두 개와 띄어쓰기만 입력해 주세요. ");
        }

        int index = 0;

        while (Character.isDigit(inputString.charAt(index))) {
            index++;
        }

        arr[0] = Integer.valueOf(inputString.substring(0, index));
        arr[1] = Integer.valueOf(inputString.substring(index + 1, inputString.length()));

        return arr;
    }

    private boolean isValidInput(String inputString) {
        String target = inputString.trim();
        int count = 0;

        for (int i = 0; i < target.length(); i++) {
            if (!Character.isDigit(inputString.charAt(i))) {
                count++;
            }
        }

        return count == 1;
    }

}
