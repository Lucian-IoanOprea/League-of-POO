package angels;

import main.Pair;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class TheDoomer extends Angels {

    TheDoomer(final String name, final Pair<Integer, Integer> mypair) {
        super(name, mypair);
    }

    /**
     * @param hero visitor pattern method.
     */
    public void visit1(final Wizard hero) {
        if (hero.checkalive()) {
            hero.kill();
            String aux = "TheDoomer" + " " + "hit" + " " + "Wizard" + " " + hero.getId();
            String aux1 = "Player Wizard" + " " + hero.getId() + " " + "was killed by an angel";
            super.notifyAllObservers(aux);
            super.notifyAllObservers(aux1);
        }
    }

    /**
     * @param hero visitor pattern method.
     */
    public void visit1(final Knight hero) {
        if (hero.checkalive()) {
            hero.kill();
            String aux = "TheDoomer" + " " + "hit" + " " + "Knight" + " " + hero.getId();
            String aux1 = "Player Knight" + " " + hero.getId() + " " + "was killed by an angel";
            super.notifyAllObservers(aux);
            super.notifyAllObservers(aux1);
        }

    }

    /**
     * @param hero visitor pattern method.
     */
    public void visit1(final Pyromancer hero) {
        if (hero.checkalive()) {
            hero.kill();
            String aux = "TheDoomer" + " " + "hit" + " " + "Pyromancer" + " " + hero.getId();
            String aux1 = "Player Pyromancer" + " " + hero.getId() + " " + "was killed by an angel";
            super.notifyAllObservers(aux);
            super.notifyAllObservers(aux1);
        }

    }

    /**
     * @param hero visitor pattern method.
     */
    public void visit1(final Rogue hero) {
        if (hero.checkalive()) {
            hero.kill();
            String aux = "TheDoomer" + " " + "hit" + " " + "Rogue" + " " + hero.getId();
            String aux1 = "Player Rogue" + " " + hero.getId() + " " + "was killed by an angel";
            super.notifyAllObservers(aux);
            super.notifyAllObservers(aux1);
        }
    }
}
