package abilities;

import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public interface Ability {
    /**
     * @param hero
     */
    void visit(Wizard hero);

    /**
     * @param hero
     */
    void visit(Rogue hero);

    /**
     * @param hero
     */
    void visit(Knight hero);

    /**
     * @param hero
     */
    void visit(Pyromancer hero);
}
