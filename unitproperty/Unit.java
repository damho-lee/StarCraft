package unitproperty;

/**
 * Unit
 */
public class Unit {
    private int offensePower;
    private int defensePower;

    protected Unit(int offensePower, int defensePower) {
        this.offensePower = offensePower;
        this.defensePower = defensePower;
    }

    private int getOffensePower() {
        return this.offensePower;
    }

    public boolean getDamage(Unit unit) {
        if (this.defensePower <= unit.getOffensePower()) {
            return true;
        }

        this.defensePower -= unit.getOffensePower();
        return false;
    }
}