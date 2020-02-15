package angels;

import constants.*;
import main.Pair;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class Dracula extends Angels {


    Dracula(final String name, final Pair<Integer, Integer> mypair) {
        super(name, mypair);
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Wizard hero) {
        if (hero.checkalive()) {
            hero.wizmodify(-AngelsConstants.VARIABLE_AUX4);
            String aux = "Dracula" + " " + "hit" + " " + "Wizard" + " " + hero.getId();
            super.notifyAllObservers(aux);
            hero.substractHp(AngelsConstants.VARIABLE_AUX20);


        }

    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Knight hero) {
        if (hero.checkalive()) {
            hero.knightmodify(-AngelsConstants.VARIABLE_AUX2);
            String aux = "Dracula" + " " + "hit" + " " + "Knight" + " " + hero.getId();
            super.notifyAllObservers(aux);
            hero.substractHp(AngelsConstants.VARIABLE_AUX60);


        }
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Pyromancer hero) {
        if (hero.checkalive()) {
            hero.pyromodify(-AngelsConstants.VARIABLE_AUX3);
            String aux = "Dracula" + " " + "hit" + " " + "Pyromancer" + " " + hero.getId();
            super.notifyAllObservers(aux);
            hero.substractHp(AngelsConstants.VARIABLE_AUX40);

        }
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Rogue hero) {
        if (hero.checkalive()) {
            hero.roguemodify(-AngelsConstants.VARIABLE_AUX1);
            String aux = "Dracula" + " " + "hit" + " " + "Rogue" + " " + hero.getId();
            super.notifyAllObservers(aux);
            hero.substractHp(AngelsConstants.VARIABLE_AUX35);


        }
    }

}
