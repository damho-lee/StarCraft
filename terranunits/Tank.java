package terranunits;

import race.Terran;
import unitproperty.CanNotFly;

public class Tank extends Terran implements CanNotFly{
    public Tank() {
        super(7, 15);
    }
}
