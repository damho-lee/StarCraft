package terranunits;

import unitproperty.CanFly;
import unitproperty.Unit;

public class BattleCruzer extends Unit implements CanFly {

    public BattleCruzer(int offensePower, int defensePower, String name) {
        super(20, 30, "BattleCruzer");
    }

}
