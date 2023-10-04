package terranunits;

import race.Terran;
import unitproperty.CanNotFly;

public final class Marin extends Terran implements CanNotFly {

    public Marin() {
        super(3, 10, "Marin");
    }
}