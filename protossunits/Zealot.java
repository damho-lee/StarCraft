package protossunits;

import race.Protoss;
import unitproperty.CanNotFly;

public final class Zealot extends Protoss implements CanNotFly {

    public Zealot() {
        super(5, 20, "Zealot");
    }
}
