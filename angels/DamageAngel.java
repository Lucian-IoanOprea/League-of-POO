package angels;


import constants.AngelsConstants;
import main.Pair;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

/**
 *
 */
public class DamageAngel extends Angels {

    DamageAngel(final String name, final Pair<Integer, Integer> mypair) {
        super(name, mypair);
    }


    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Wizard hero) {
        if (hero.checkalive()) {
            hero.wizmodify(AngelsConstants.VARIABLE_AUX4);
            String aux = "DamageAngel" + " " + "helped" + " " + "Wizard" + " " + hero.getId();
            super.notifyAllObservers(aux);
        }
    }


    /**
     * @param hero
     * visitor pattern method.
     */
    public void visit1(final Knight hero) {
        if (hero.checkalive()) {
            hero.knightmodify(AngelsConstants.VARIABLE_AUX015);
            String aux = "DamageAngel" + " " + "helped" + " " + "Knight" + " " + hero.getId();
            super.notifyAllObservers(aux);
        }
    }

    /**
     * @param hero
     * visitor pattern method.
     */
    public void visit1(final Pyromancer hero) {
        if (hero.checkalive()) {
            hero.pyromodify(AngelsConstants.VARIABLE_AUX2);
            String aux = "DamageAngel" + " " + "helped" + " " + "Pyromancer" + " " + hero.getId();
            super.notifyAllObservers(aux);
        }
    }


    /**
     * @param hero
     * visitor pattern method.
     */
    public void visit1(final Rogue hero) {
        if (hero.checkalive()) {
            hero.roguemodify(AngelsConstants.VARIABLE_AUX3);
            String aux = "DamageAngel" + " " + "helped" + " " + "Rogue" + " " + hero.getId();
            super.notifyAllObservers(aux);
        }
    }

}
