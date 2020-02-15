package abilities;


import constants.AngelsConstants;
import constants.StrategyConstants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class AttackStrategy implements Strategy {
    /**
     * @param hero
     */
    public void execute(final Knight hero) {
        hero.setHp(hero.getHp() - hero.getHp() / StrategyConstants.VARIABLE_AUX5);
        hero.knightmodify(AngelsConstants.VARIABLE_AUX5);
    }

    /**
     * @param hero
     */
    public void execute(final Wizard hero) {
        hero.setHp(hero.getHp() - hero.getHp() / StrategyConstants.VARIABLE_AUX10);
        hero.wizmodify(AngelsConstants.VARIABLE_AUX6);
    }

    /**
     * @param hero
     */
    public void execute(final Pyromancer hero) {
        hero.setHp(hero.getHp() - hero.getHp() / StrategyConstants.VARIABLE_AUX4);
        hero.pyromodify(AngelsConstants.VARIABLE_AUX7);
    }

    /**
     * @param hero
     */
    public void execute(final Rogue hero) {
        hero.setHp(hero.getHp() - hero.getHp() / StrategyConstants.VARIABLE_AUX7);
        hero.roguemodify(AngelsConstants.VARIABLE_AUX4);
    }

}
