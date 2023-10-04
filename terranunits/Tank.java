package terranunits;

import race.Terran;
import unitproperty.CanNotFly;

public final class Tank extends Terran implements CanNotFly {

    public Tank() {
        super(7, 15, "Tank");
    }
}
