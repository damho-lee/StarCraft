package game;

import java.util.List;

import unitproperty.*;

public class Player {
    private String name;
    private String race;
    private List<? extends Unit> unitList;

    public Player(String name, String race) {
        this.name = name;
        if (!race.equals("protoss") &&
                !race.equals("zerg") &&
                !race.equals("terran")) {
            throw new IllegalArgumentException("종족은 Protoss, Zerg, Terran 3개 중에 선택해주세요.");
        }
        this.race = race;
        this.unitList = makeUnits(this.race);
    }

    private List<? extends Unit> makeUnits(String race) {
        if (race.equals("protoss")) {
            return UnitMaker.makeProtossUnits();
        } else if (race.equals("zerg")) {
            return UnitMaker.makeZergUnits();
        } else {
            return UnitMaker.makeTerranUnits();
        }
    }

    public void printPlayerUnits() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.unitList.size(); i++) {
            Unit unit = this.unitList.get(i);
            builder.append(i + "." + unit.getName() + "(" + "현재 방어력: " + unit.getDefensePower() + ")\n");
        }
        System.out.println(builder);
    }

    public String getName() {
        return this.name;
    }

    public String getRace() {
        return this.race;
    }

    public int numberOfUnits() {
        return unitList.size();
    }

    public Unit getUnit(int index) {
        if (index < 0 || index >= numberOfUnits()) {
            throw new IllegalArgumentException("index가 범위 밖입니다.");
        }
        return this.unitList.get(index);
    }

    public boolean attack(int index, Unit target) {
        Unit unit = getUnit(index);

        if (unit instanceof CanFly) {
            ((CanFly) unit).attack(target);
        } else if (unit instanceof Weapon) {
            ((Weapon) unit).attack(target);
        } else {
            try {
                ((CanNotFly) unit).attack(target);
            } catch (IllegalArgumentException exception) {
                throw new IllegalArgumentException(exception.getMessage());
            }
        }
        return target.getDamage(unit);
    }

    public void remove(int index) {
        if (index < 0 || index >= numberOfUnits()) {
            throw new IllegalArgumentException("index가 범위 밖입니다.");
        }
        unitList.remove(index);
    }

    public boolean isAllCanFly() {
        for (int i = 0; i < numberOfUnits(); i++) {
            if (!(this.unitList.get(i) instanceof CanFly)) {
                return false;
            }
        }
        return true;
    }

    public boolean isAllCanNotFly() {
        for (int i = 0; i < numberOfUnits(); i++) {
            if (!(this.unitList.get(i) instanceof CanNotFly)) {
                return false;
            }
        }
        return true;
    }
}
