package angels;

import constants.*;
import main.Pair;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class GoodBoy extends Angels {


    GoodBoy(final String name, final Pair<Integer, Integer> mypair) {
        super(name, mypair);
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Wizard hero) {
        if (hero.checkalive()) {
            hero.wizmodify(AngelsConstants.VARIABLE_AUX3);
            hero.addhp(AngelsConstants.VARIABLE_AUX50);
            String aux = "GoodBoy" + " " + "helped" + " " + "Wizard" + " " + hero.getId();
            super.notifyAllObservers(aux);
        }
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Knight hero) {
        if (hero.checkalive()) {
            hero.knightmodify(AngelsConstants.VARIABLE_AUX4);
            hero.addhp(AngelsConstants.VARIABLE_AUX20);
            String aux = "GoodBoy" + " " + "helped" + " " + "Knight" + " " + hero.getId();
            super.notifyAllObservers(aux);
        }
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Pyromancer hero) {
        if (hero.checkalive()) {
            hero.pyromodify(AngelsConstants.VARIABLE_AUX5);
            hero.addhp(AngelsConstants.VARIABLE_AUX30);
            String aux = "GoodBoy" + " " + "helped" + " " + "Pyromancer" + " " + hero.getId();
            super.notifyAllObservers(aux);
        }
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Rogue hero) {
        if (hero.checkalive()) {
            hero.roguemodify(AngelsConstants.VARIABLE_AUX4);
            hero.addhp(AngelsConstants.VARIABLE_AUX40);
            String aux = "GoodBoy" + " " + "helped" + " " + "Rogue" + " " + hero.getId();
            super.notifyAllObservers(aux);
        }
    }
}
