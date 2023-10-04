package game;

import race.*;
import terranunits.*;
import unitproperty.Unit;
import protossunits.*;
import zergunits.*;
import java.util.ArrayList;
import java.util.List;

public class UnitMaker {
    private static final int NUMBEROFTERRANUNIT = 5;
    private static final int NUMBEROFPROTOSSUNIT = 4;
    private static final int NUMBEROFZERGUNIT = 8;

    // private static final Protoss[] protossUnits = { new Zealot(), new Dragoon(),
    // new HighTempler(), new Scout(),
    // new Corsair() };
    // private static final Terran[] terranUnits = { new Marin(), new Tank(), new
    // Goliath(), new Wraith(),
    // new Valkyrie() };
    // private static final Zerg[] zergUnits = { new Zergling(), new Hydralisk(),
    // new Ultralisk(), new Mutalisk(),
    // new Guardian() };

    private UnitMaker() {
    }

    public static List<Unit> makeTerranUnits() {
        List<Unit> unitList = new ArrayList<>();
        for (int i = 0; i < NUMBEROFTERRANUNIT; i++) {
            int random = (int) (Math.random() * 5);
            switch (random) {
                case 0:
                    unitList.add(new Marin());
                    break;
                case 1:
                    unitList.add(new Tank());
                    break;
                case 2:
                    unitList.add(new Goliath());
                    break;
                case 3:
                    unitList.add(new Wraith());
                    break;
                case 4:
                    unitList.add(new Valkyrie());
                    break;
                default:
                    throw new IllegalArgumentException("random의 값이 잘 못 설정되었습니다.");
            }
        }
        return unitList;
    }

    public static List<Protoss> makeProtossUnits() {
        List<Protoss> unitList = new ArrayList<>();
        for (int i = 0; i < NUMBEROFPROTOSSUNIT; i++) {
            int random = (int) (Math.random() * 5);
            switch (random) {
                case 0:
                    unitList.add(new Zealot());
                    break;
                case 1:
                    unitList.add(new Dragoon());
                    break;
                case 2:
                    unitList.add(new HighTempler());
                    break;
                case 3:
                    unitList.add(new Scout());
                    break;
                case 4:
                    unitList.add(new Corsair());
                    break;
                default:
                    throw new IllegalArgumentException("random의 값이 잘 못 설정되었습니다.");
            }
        }
        return unitList;
    }

    public static List<Unit> makeZergUnits() {
        List<Unit> unitList = new ArrayList<>();
        for (int i = 0; i < NUMBEROFZERGUNIT; i++) {
            int random = (int) (Math.random() * 5);
            switch (random) {
                case 0:
                    unitList.add(new Zergling());
                    break;
                case 1:
                    unitList.add(new Hydralisk());
                    break;
                case 2:
                    unitList.add(new Ultralisk());
                    break;
                case 3:
                    unitList.add(new Mutalisk());
                    break;
                case 4:
                    unitList.add(new Guardian());
                    break;
                default:
                    throw new IllegalArgumentException("random의 값이 잘 못 설정되었습니다.");
            }
        }
        return unitList;
    }
}
