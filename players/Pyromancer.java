package players;

import abilities.*;
import angels.Angels;
import constants.PlayersConstants;
import constants.PyromancerConstants;
import constants.StrategyConstants;
import main.Observer;
import main.Pair;

import java.util.ArrayList;
import java.util.List;

public class Pyromancer extends Players {
    private float rogueModify;
    private float knightModify;
    private float pyroModify;
    private float wizardModify;
    private List<Observer> observers;

    Pyromancer(final Pair<Integer, Integer> mypair) {
        super(mypair);
        this.setHp(PlayersConstants.FIVE_HUNDREAD);
        this.setMaxHp(PlayersConstants.FIVE_HUNDREAD);
        rogueModify = PyromancerConstants.ROGUE_MODIFY;
        knightModify = PyromancerConstants.KNIGHT_MODIFY;
        pyroModify = PyromancerConstants.PYRO_MODIFY;
        wizardModify = PyromancerConstants.WIZARD_MODIFY;
        observers = new ArrayList<>();
    }

    Pyromancer() {

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
    @Override
    public void accept1(final Angels myangel) {
        myangel.visit1(this);
    }

    /**
     * get the ability of the hero.
     */
    public Ability heroAbility() {
        return new PyromancerAbility(this);
    }

    /**
     * method that chooses a strategy.
     */
    public void chooseStrategy() {
        if (super.getMaxHp() / StrategyConstants.VARIABLE_AUX4 < super.getHp() && super.getHp()
                < super.getMaxHp() / StrategyConstants.VARIABLE_AUX3) {
            this.setCurrentStrategy(new AttackStrategy());
        } else if (super.getHp() < super.getMaxHp() / StrategyConstants.VARIABLE_AUX4) {
            this.setCurrentStrategy(new DefensiveStrategy());
        }
        else {
            this.setCurrentStrategy(new BasicStrategy());
        }
        super.getCurrentStrategy().execute(this);
    }

    /**
     * method that changes the modifiers.
     */
    public void pyromodify(final float data) {
        pyroModify += data;
        knightModify += data;
        rogueModify += data;
        wizardModify += data;
    }

    /**
     * for observer pattern.
     */
    public void voidaddobserver(final Observer yes) {
        observers.add(yes);
    }

    /**
     * to notify Great Magician.
     */
    public void notifyAllObservers(final String mystring) {
        for (Observer observer : observers) {
            observer.update(mystring);
        }
    }

    /**
     * returns rogueModify.
     */
    public float getRogueModify() {
        return rogueModify;
    }
    /**
     * returns knightModify.
     */
    public float getKnightModify() {
        return knightModify;
    }
    /**
     * returns pyroModify.
     */
    public float getPyroModify() {
        return pyroModify;
    }
    /**
     * returns wizardModify.
     */
    public float getWizardModify() {
        return wizardModify;
    }
}
