package zergunits;

import race.Zerg;
import unitproperty.CanFly;

public class Mutalisk extends Zerg implements CanFly {

    protected Mutalisk() {
        super(2, 8);
    }
}
