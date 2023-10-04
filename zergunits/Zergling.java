package zergunits;

import race.Zerg;
import unitproperty.CanNotFly;

public final class Zergling extends Zerg implements CanNotFly {

    public Zergling() {
        super(2, 2, "Zergling");
    }
}
