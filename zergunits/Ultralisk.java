package zergunits;

import race.Zerg;
import unitproperty.CanNotFly;

public final class Ultralisk extends Zerg implements CanNotFly {

    public Ultralisk() {
        super(5, 15, "Ultralisk");
    }
}
