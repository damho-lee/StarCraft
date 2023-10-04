package protossunits;

import unitproperty.CanFly;
import unitproperty.Unit;

public class Carrier extends Unit implements CanFly {

    public Carrier(int offensePower, int defensePower, String name) {
        super(25, 40, "Carrier");
    }

}
