package zergunits;

import race.Zerg;
import unitproperty.CanNotFly;

public class Ultralisk extends Zerg implements CanNotFly {

    protected Ultralisk() {
        super(5, 15);
    }

}
