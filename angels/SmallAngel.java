package angels;

import constants.*;
import main.Pair;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class SmallAngel extends Angels {

    SmallAngel(final String name, final Pair<Integer, Integer> mypair) {
        super(name, mypair);
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Wizard hero) {
        if (hero.checkalive()) {
            hero.wizmodify(AngelsConstants.VARIABLE_AUX1);
            hero.addhp(AngelsConstants.VARIABLE_AUX25);
            String aux = "SmallAngel" + " " + "helped" + " " + "Wizard" + " " + hero.getId();
            super.notifyAllObservers(aux);
        }
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Knight hero) {
        if (hero.checkalive()) {
            hero.knightmodify(AngelsConstants.VARIABLE_AUX1);
            hero.addhp(AngelsConstants.VARIABLE_AUX10);
            String aux = "SmallAngel" + " " + "helped" + " " + "Knight" + " " + hero.getId();
            super.notifyAllObservers(aux);
        }
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Pyromancer hero) {
        if (hero.checkalive()) {
            hero.pyromodify(AngelsConstants.VARIABLE_AUX015);
            hero.addhp(15);
            String aux = "SmallAngel" + " " + "helped" + " " + "Pyromancer" + " " + hero.getId();
            super.notifyAllObservers(aux);
        }
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Rogue hero) {
        if (hero.checkalive()) {
            hero.roguemodify(0.05f);
            hero.addhp(AngelsConstants.VARIABLE_AUX20);
            String aux = "SmallAngel" + " " + "helped" + " " + "Rogue" + " " + hero.getId();
            super.notifyAllObservers(aux);
        }
    }
}
