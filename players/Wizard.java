package players;

import abilities.*;
import angels.Angels;
import constants.PlayersConstants;
import constants.StrategyConstants;
import constants.WizardConstants;
import main.Observer;
import main.Pair;


public class Wizard extends Players {
    private float deflectRogue;
    private float deflectKnight;
    private float deflectPyromancer;

    private float drainKnight;
    private float drainPyromancer;


    private float drainWizard;
    private float drainRogue;

    Wizard(final Pair<Integer, Integer> mypair) {
        super(mypair);
        this.setHp(PlayersConstants.FOUR_HUNDREAD);
        this.setMaxHp(PlayersConstants.FOUR_HUNDREAD);
        deflectRogue = WizardConstants.DEFLECT_ROGUE;
        deflectKnight = WizardConstants.DEFLECT_KNIGHT;
        deflectPyromancer = WizardConstants.DEFLECT_PYROMANCER;
        drainKnight = WizardConstants.DRAIN_KNIGHT;
        drainPyromancer = WizardConstants.DRAIN_PYROMANCER;
        drainWizard = WizardConstants.DRAIN_WIZARD;
        drainRogue = WizardConstants.DRAIN_ROGUE;
    }

    Wizard() {

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
        return new WizardAbility(this);
    }

    /**
     * method that chooses the right strategy.
     */
    public void chooseStrategy() {
        if (super.getMaxHp() / StrategyConstants.VARIABLE_AUX4 < super.getHp() && super.getHp()
                < super.getMaxHp() / StrategyConstants.VARIABLE_AUX2) {
            this.setCurrentStrategy(new AttackStrategy());
        } else if (super.getHp() < super.getMaxHp() / StrategyConstants.VARIABLE_AUX4) {
            this.setCurrentStrategy(new DefensiveStrategy());
        } else {
            this.setCurrentStrategy(new BasicStrategy());
        }
        super.getCurrentStrategy().execute(this);
    }

    /**
     * @return deflectRogue.
     */
    public float getDeflectRogue() {
        return deflectRogue;
    }
    /**
     * @return deflectKnight.
     */
    public float getDeflectKnight() {
        return deflectKnight;
    }
    /**
     * @return deflectPyromancer.
     */
    public float getDeflectPyromancer() {
        return deflectPyromancer;
    }
    /**
     * @return drainKnight.
     */
    public float getDrainKnight() {
        return drainKnight;
    }
    /**
     * @return drainPyromancer.
     */
    public float getDrainPyromancer() {
        return drainPyromancer;
    }
    /**
     * @return drainWizard.
     */
    public float getDrainWizard() {
        return drainWizard;
    }
    /**
     * @return drainRogue.
     */
    public float getDrainRogue() {
        return drainRogue;
    }
    /**
     * method to change modifiers.
     */
    public void wizmodify(final float data) {
        deflectKnight += data;
        deflectPyromancer += data;
        deflectRogue += data;
        drainRogue += data;
        drainPyromancer += data;
        drainKnight += data;
        drainWizard += data;
    }

    /**
     * @param yes
     */
    public void voidaddobserver(final Observer yes) {
        observers.add(yes);
    }

    /**
     * @param mystring
     */
    public void notifyAllObservers(final String mystring) {
        for (Observer observer : observers) {
            observer.update(mystring);
        }
    }

}
