package zergunits;

import race.Zerg;
import unitproperty.CanFly;

public class Guardian extends Zerg implements CanFly {

    protected Guardian() {
        super(3, 6);
    }
}
