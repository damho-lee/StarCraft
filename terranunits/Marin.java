package terranunits;

import race.Terran;
import unitproperty.CanNotFly;

public class Marin extends Terran implements CanNotFly {
    public Marin() {
        super(3, 10);
    }
}