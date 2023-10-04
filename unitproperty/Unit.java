package unitproperty;

/**
 * Unit
 */
public class Unit {
    private int offensePower;
    private int defensePower;
    private final String name;

    protected Unit(int offensePower, int defensePower, String name) {
        this.offensePower = offensePower;
        this.defensePower = defensePower;
        this.name = name;
    }

    public int getOffensePower() {
        return this.offensePower;
    }

    public int getDefensePower() {
        return this.defensePower;
    }

    public String getName() {
        return this.name;
    }

    public boolean getDamage(Unit unit) {
        if (this.defensePower <= unit.getOffensePower()) {
            return true;
        }

        this.defensePower -= unit.getOffensePower();
        return false;
    }

}