package angels;

import constants.*;
import main.Pair;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class LevelUpAngel extends Angels {
    LevelUpAngel(final String name, final Pair<Integer, Integer> mypair) {
        super(name, mypair);
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Wizard hero) {
        if (hero.checkalive()) {
            String aux = "LevelUpAngel" + " " + "helped" + " " + "Wizard" + " " + hero.getId();
            super.notifyAllObservers(aux);
            hero.nextlevelxp();
            hero.wizmodify(AngelsConstants.VARIABLE_AUX025);


        }

    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Knight hero) {
        if (hero.checkalive()) {
            String aux = "LevelUpAngel" + " " + "helped" + " " + "Knight" + " " + hero.getId();
            super.notifyAllObservers(aux);
            hero.nextlevelxp();
            hero.knightmodify(AngelsConstants.VARIABLE_AUX1);
        }
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Pyromancer hero) {
        if (hero.checkalive()) {
            String aux = "LevelUpAngel" + " " + "helped" + " " + "Pyromancer" + " " + hero.getId();
            super.notifyAllObservers(aux);
            hero.nextlevelxp();
            hero.pyromodify(AngelsConstants.VARIABLE_AUX2);

        }
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Rogue hero) {
        if (hero.checkalive()) {
            String aux = "LevelUpAngel" + " " + "helped" + " " + "Rogue" + " " + hero.getId();
            super.notifyAllObservers(aux);
            hero.nextlevelxp();
            hero.roguemodify(AngelsConstants.VARIABLE_AUX015);


        }
    }

}
