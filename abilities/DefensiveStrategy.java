package abilities;


import constants.AngelsConstants;
import constants.StrategyConstants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class DefensiveStrategy implements Strategy {
    /**
     * @param hero
     */
    public void execute(final Wizard hero) {
        hero.addhp(Math.round(hero.getHp() / StrategyConstants.VARIABLE_AUX5));
        hero.wizmodify(-AngelsConstants.VARIABLE_AUX2);
    }

    /**
     * @param hero
     */
    public void execute(final Knight hero) {
        hero.addhp(hero.getHp() / StrategyConstants.VARIABLE_AUX4);
        hero.knightmodify(-AngelsConstants.VARIABLE_AUX2);
    }

    /**
     * @param hero
     */
    public void execute(final Pyromancer hero) {
        hero.addhp(hero.getHp() / StrategyConstants.VARIABLE_AUX3);
        hero.pyromodify(-AngelsConstants.VARIABLE_AUX3);
    }

    /**
     * @param hero
     */
    public void execute(final Rogue hero) {
        hero.addhp(hero.getHp() / StrategyConstants.VARIABLE_AUX2);
        hero.roguemodify(-AngelsConstants.VARIABLE_AUX1);
    }
}
