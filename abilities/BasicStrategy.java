package abilities;

import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class BasicStrategy implements Strategy {

    /**
     * @param hero
     */
    public void execute(final Wizard hero) {
        return;
    }

    /**
     * @param hero
     */
    @Override
    public void execute(final Knight hero) {
        return;
    }

    /**
     * @param hero
     */
    @Override
    public void execute(final Pyromancer hero) {
        return;
    }

    /**
     * @param hero
     */
    @Override
    public void execute(final Rogue hero) {
        return;
    }

}
