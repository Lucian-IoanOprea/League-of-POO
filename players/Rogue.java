package players;

import abilities.*;
import angels.Angels;
import constants.PlayersConstants;
import constants.RogueConstants;
import constants.StrategyConstants;
import main.Observer;
import main.Pair;


/**
 *
 */
public class Rogue extends Players {
    private float backstabKnight;
    private float paralysisKnight;
    private float backstabPyromancer;
    private float paralysisPyromancer;

    private float backstabRogue;
    private float paralysisRogue;

    private float backstabWizard;
    private float paralysisWizard;

    Rogue(final Pair<Integer, Integer> mypair) {
        super(mypair);
        this.setHp(PlayersConstants.SIX_HUNDREAD);
        this.setMaxHp(PlayersConstants.SIX_HUNDREAD);
        backstabKnight = RogueConstants.BACKStab_KNIGHT;
        paralysisKnight = RogueConstants.PARALYSIS_KNIGHT;
        backstabPyromancer = RogueConstants.BACKSTAB_PYROMANCER;
        paralysisPyromancer = RogueConstants.PARALYSIS_PYROMANCER;
        backstabRogue = RogueConstants.BACKSTAB_ROGUE;
        paralysisRogue = RogueConstants.PARALYSIS_ROGUE;
        backstabWizard = RogueConstants.BACKSTAB_WIZARD;
        paralysisWizard = RogueConstants.PARALYSIS_WIZARD;
    }

    Rogue() {

    }

    /**
     * visitor pattern accept.
     */
    public void accept(final Ability power) {
        power.visit(this);
    }

    /**
     * @param myangel
     */
    public void accept1(final Angels myangel) {
        myangel.visit1(this);
    }

    /**
     * get the ability of the hero.
     */
    public Ability heroAbility() {
        int a = super.getBackstab();
        super.setBackstab(a + 1);
        return new RogueAbility(this);
    }

    /**
     * method that chooses the strategy.
     */
    public void chooseStrategy() {
        if (super.getMaxHp() / StrategyConstants.VARIABLE_AUX7
                < super.getHp() && super.getHp()
                < super.getMaxHp() / StrategyConstants.VARIABLE_AUX5) {
            this.setCurrentStrategy(new AttackStrategy());
        } else if (super.getHp() < super.getMaxHp() / StrategyConstants.VARIABLE_AUX7) {
            this.setCurrentStrategy(new DefensiveStrategy());
        } else {
            this.setCurrentStrategy(new BasicStrategy());
        }
        super.getCurrentStrategy().execute(this);
    }

    /**
     * methods to change the modifiers.
     */
    public void roguemodify(final float data) {
        backstabPyromancer += data;
        backstabWizard += data;
        backstabKnight += data;
        backstabRogue += data;
        paralysisRogue += data;
        paralysisKnight += data;
        paralysisWizard += data;
        paralysisPyromancer += data;
    }

    /**
     * for observer pattern.
     */
    public void voidaddobserver(final Observer yes) {
        observers.add(yes);
    }

    /**
     * to notify the Great Magician.
     */
    public void notifyAllObservers(final String mystring) {
        for (Observer observer : observers) {
            observer.update(mystring);
        }
    }

    /**
     * returns the backstabKnight.
     */
    public float getBackstabKnight() {
        return backstabKnight;
    }
    /**
     * returns the paralysisKnight.
     */
    public float getParalysisKnight() {
        return paralysisKnight;
    }
    /**
     * returns the backstabPyromancer.
     */
    public float getBackstabPyromancer() {
        return backstabPyromancer;
    }
    /**
     * returns the paralysisPyromancer.
     */
    public float getParalysisPyromancer() {
        return paralysisPyromancer;
    }
    /**
     * returns the backstabRogue.
     */
    public float getBackstabRogue() {
        return backstabRogue;
    }
    /**
     * returns the paralysisRogue.
     */
    public float getParalysisRogue() {
        return paralysisRogue;
    }
    /**
     * returns the backstabWizard.
     */
    public float getBackstabWizard() {
        return backstabWizard;
    }
    /**
     * returns the paralysisWizard.
     */
    public float getParalysisWizard() {
        return paralysisWizard;
    }
}
