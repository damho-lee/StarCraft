package zergunits;

import race.Zerg;
import unitproperty.CanNotFly;

public class Zergling extends Zerg implements CanNotFly {

    protected Zergling() {
        super(2, 2);
    }
}
