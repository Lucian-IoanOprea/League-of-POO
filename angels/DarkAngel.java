package angels;

import constants.AngelsConstants;
import main.Pair;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class DarkAngel extends Angels implements VisitorCell {

    DarkAngel(final String name, final Pair<Integer, Integer> mypair) {
        super(name, mypair);
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Wizard hero) {
        if (hero.checkalive()) {
            String aux = "DarkAngel" + " " + "hit" + " " + "Wizard" + " " + hero.getId();
            hero.substractHp(AngelsConstants.VARIABLE_AUX20);
            super.notifyAllObservers(aux);
        }
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Knight hero) {
        if (hero.checkalive()) {
            String aux = "DarkAngel" + " " + "hit" + " " + "Knight" + " " + hero.getId();
            hero.substractHp(AngelsConstants.VARIABLE_AUX40);
            super.notifyAllObservers(aux);

        }
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Pyromancer hero) {
        if (hero.checkalive()) {
            String aux = "DarkAngel" + " " + "hit" + " " + "Pyromancer" + " " + hero.getId();
            hero.substractHp(AngelsConstants.VARIABLE_AUX30);
            super.notifyAllObservers(aux);

        }
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Rogue hero) {
        if (hero.checkalive()) {
            String aux = "DarkAngel" + " " + "hit" + " " + "Rogue" + " " + hero.getId();
            hero.substractHp(AngelsConstants.VARIABLE_AUX10);
            super.notifyAllObservers(aux);

        }
    }
}
