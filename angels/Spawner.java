package angels;

import constants.AngelsConstants;
import main.Pair;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class Spawner extends Angels {

    Spawner(final String name, final Pair<Integer, Integer> mypair) {
        super(name, mypair);
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Wizard hero) {
        if (!hero.checkalive()) {
            hero.revive();
            hero.setHp(AngelsConstants.VARIABLE_AUX120);
            String aux = "Spawner" + " " + "helped" + " " + "Wizard" + " " + hero.getId();
            String aux1 = "Player Wizard" + " " + hero.getId() + " "
                    + "was brought to life by an angel";
            super.notifyAllObservers(aux);
            super.notifyAllObservers(aux1);
        }
    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Knight hero) {
        if (!hero.checkalive()) {
            hero.revive();
            hero.setHp(AngelsConstants.VARIABLE_AUX200);
            String aux = "Spawner" + " " + "helped" + " " + "Knight" + " " + hero.getId();
            String aux1 = "Player Knight" + " " + hero.getId() + " "
                    + "was brought to life by an angel";
            super.notifyAllObservers(aux);
            super.notifyAllObservers(aux1);
        }

    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Pyromancer hero) {
        if (!hero.checkalive()) {
            hero.revive();
            hero.setHp(150);
            String aux = "Spawner" + " " + "helped" + " " + "Pyromancer" + " " + hero.getId();
            String aux1 = "Player Pyromancer" + " " + hero.getId() + " "
                    + "was brought to life by an angel";
            super.notifyAllObservers(aux);
            super.notifyAllObservers(aux1);
        }

    }

    /**
     * @param hero
     *  visitor pattern method.
     */
    public void visit1(final Rogue hero) {
        if (!hero.checkalive()) {
            hero.revive();
            hero.setHp(AngelsConstants.VARIABLE_AUX180);
            String aux = "Spawner" + " " + "helped" + " " + "Rogue" + " " + hero.getId();
            String aux1 = "Player Rogue" + " " + hero.getId() + " "
                    + "was brought to life by an angel";
            super.notifyAllObservers(aux);
            super.notifyAllObservers(aux1);
        }

    }
}
