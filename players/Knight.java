package players;

import abilities.*;
import angels.Angels;
import constants.KnightConstants;
import constants.PlayersConstants;
import constants.StrategyConstants;
import main.Observer;
import main.Pair;



public class Knight extends Players {
    private float knightModifyA; // A = Execute , B = slam
    private float knightModifyB;
    private float rogueModifyA;
    private float rogueModifyB;
    private float pyroModifyA;

    /**
     * return knightModifyA.
     */
    public float getKnightModifyA() {
        return knightModifyA;
    }
    /**
     * return knightModifyB.
     */
    public float getKnightModifyB() {
        return knightModifyB;
    }
    /**
     * return rogueModifyA.
     */
    public float getRogueModifyA() {
        return rogueModifyA;
    }
    /**
     * return rogueModifyB.
     */
    public float getRogueModifyB() {
        return rogueModifyB;
    }
    /**
     * return pyroModifyA.
     */
    public float getPyroModifyA() {
        return pyroModifyA;
    }
    /**
     * return pyroModifyB.
     */
    public float getPyroModifyB() {
        return pyroModifyB;
    }
    /**
     * return wizardModifyA.
     */
    public float getWizardModifyA() {
        return wizardModifyA;
    }
    /**
     * return wizardModifyB.
     */
    public float getWizardModifyB() {
        return wizardModifyB;
    }

    private float pyroModifyB;
    private float wizardModifyA;
    private float wizardModifyB;

    Knight(final Pair<Integer, Integer> mypair) {
        super(mypair);
        this.setHp(PlayersConstants.NINE_HUNDREAD);
        this.setMaxHp(PlayersConstants.NINE_HUNDREAD);
        knightModifyA = KnightConstants.KNIGHT_MODIFYA; // A = Execute , B = slam
        knightModifyB = KnightConstants.KNiGHT_MODIFYB;
        rogueModifyA = KnightConstants.ROGUE_MODIFYA;
        rogueModifyB = KnightConstants.ROGUE_MODIFYB;
        pyroModifyA = KnightConstants.PYRO_MODIFYA;
        pyroModifyB = KnightConstants.PYRO_MODIFYB;
        wizardModifyA = KnightConstants.WIZARD_MODIFYA;
        wizardModifyB = KnightConstants.WIZARD_MODIFYB;

    }

    Knight() {

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
        return new KnightAbility(this);
    }

    /**
     * method that chooses the strategy.
     */
    public void chooseStrategy() {
        if (super.getMaxHp() / StrategyConstants.VARIABLE_AUX3
                < super.getHp() && super.getHp() < super.getMaxHp() / StrategyConstants.VARIABLE_AUX2) {
            this.setCurrentStrategy(new AttackStrategy());
        } else if (super.getHp() < super.getMaxHp() / StrategyConstants.VARIABLE_AUX3) {

            this.setCurrentStrategy(new DefensiveStrategy());
        } else {
            this.setCurrentStrategy(new BasicStrategy());
        }
        super.getCurrentStrategy().execute(this);
    }

    /**
     * method that changes the modifiers.
     */
    public void knightmodify(final float data) {
        pyroModifyA += data;
        pyroModifyB += data;
        wizardModifyA += data;
        wizardModifyB += data;
        rogueModifyA += data;
        rogueModifyB += data;
        knightModifyB += data;

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
