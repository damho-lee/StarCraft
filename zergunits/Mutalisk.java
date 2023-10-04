package zergunits;

import race.Zerg;
import unitproperty.CanFly;

public final class Mutalisk extends Zerg implements CanFly {

    public Mutalisk() {
        super(2, 8, "Mutalisk");
    }
}
