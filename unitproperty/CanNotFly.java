package unitproperty;

public interface CanNotFly {
    public default void attack(Unit unit) {
        if (unit instanceof CanFly) {
            throw new IllegalArgumentException("날 수 없는 유닛은 날 수 있는 유닛을 공격할 수 없습니다.");
        }
    }
}
