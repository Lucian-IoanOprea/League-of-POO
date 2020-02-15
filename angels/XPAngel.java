package angels;

import constants.AngelsConstants;
import main.Pair;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class XPAngel extends Angels {

    XPAngel(final String name, final Pair<Integer, Integer> mypair) {
        super(name, mypair);
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Wizard hero) {
        if (hero.checkalive()) {
            String aux = "XPAngel" + " " + "helped" + " " + "Wizard" + " " + hero.getId();
            super.notifyAllObservers(aux);
            hero.addxp(AngelsConstants.VARIABLE_AUX60);

        }
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Knight hero) {
        if (hero.checkalive()) {
            String aux = "XPAngel" + " " + "helped" + " " + "Knight" + " " + hero.getId();
            super.notifyAllObservers(aux);
            hero.addxp(45);

        }
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Pyromancer hero) {
        if (hero.checkalive()) {
            String aux = "XPAngel" + " " + "helped" + " " + "Pyromancer" + " " + hero.getId();
            super.notifyAllObservers(aux);
            hero.addxp(AngelsConstants.VARIABLE_AUX50);

        }
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Rogue hero) {
        if (hero.checkalive()) {
            String aux = "XPAngel" + " " + "helped" + " " + "Rogue" + " " + hero.getId();
            super.notifyAllObservers(aux);
            hero.addxp(AngelsConstants.VARIABLE_AUX40);


        }
    }
}
