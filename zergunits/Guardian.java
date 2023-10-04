package zergunits;

import race.Zerg;
import unitproperty.CanFly;

public final class Guardian extends Zerg implements CanFly {

    public Guardian() {
        super(3, 6, "Guardian");
    }
}
