package players;

import abilities.Ability;
import abilities.Strategy;
import angels.Angels;
import constants.*;
import main.Observer;
import main.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * class that implements all the variables.
 * required for a player.
 */
public abstract class Players {
    private int xp = 0;
    private int level = 0;
    private int hp;
    private int maxHp;
    private boolean dead = false;
    private String name;
    private Pair<Integer, Integer> position;
    private Strategy currentStrategy;
    private int immobile = 0;
    private int passiveDamage = 0;
    private int passivecattacks = 0;
    private int backstab = 0;
    private int id;
    private String nickname;
    List<Observer> observers = new ArrayList<>();

    Players() {

    }

    /**
     * setter for id.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * getter for the race.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * getter for id.
     */
    public int getId() {
        return id;
    }

    /**
     * setter for the strategy.
     */
    public void setCurrentStrategy(final Strategy currentStrategy) {
        this.currentStrategy = currentStrategy;
    }

    /**
     * getter for the strategy.
     */
    public Strategy getCurrentStrategy() {
        return currentStrategy;
    }

    Players(final Pair<Integer, Integer> mypair) {
        position = mypair;
        this.passivecattacks = 0;
        this.immobile = 0;
        this.passiveDamage = 0;
    }

    /**
     * setter for the number of backstabs.
     */
    public void setBackstab(final int backstab) {
        this.backstab = backstab;
    }

    /**
     * getter for the number of backstabs.
     */
    public int getBackstab() {
        return backstab;
    }

    /**
     * getter for the xp points.
     */
    public int getXp() {
        return xp;
    }

    /**
     * getter for the level.
     */
    public int getLevel() {
        return level;
    }

    /**
     * getter for the name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * checks if a player is still alive.
     */
    public boolean checkalive() {
        if (this.dead) {
            return false;
        }
        return true;
    }

    /**
     * getter for the number of immobilized rounds.
     */
    public int getImmobile() {
        return immobile;
    }

    /**
     * increment xp.
     */
    public void addxp(final int xpp) {
        this.xp += xpp;
        calculatelevel();
    }

    /**
     * getter for Hp points.
     */
    public int getHp() {
        return hp;
    }

    /**
     * getter for Max Hp points.
     */
    public int getMaxHp() {
        return maxHp;
    }

    /**
     * checks if a player is still alive.
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * getter for the position in the map.
     */
    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    /**
     * setter for the xp points.
     */
    public void setXp(final int xpp) {
        this.xp = xpp;
    }

    /**
     * kills a hero.
     */
    public void kill() {
        this.dead = true;
    }

    /**
     * methods for moving the players.
     */
    public void update(final int x, final int y) {
        if (this.checkalive()) {
            if (this.immobile != 0) {
                this.immobile--;
            } else {
                Pair<Integer, Integer> mypair = new Pair<Integer, Integer>(x, y);
                this.position = mypair;
            }
        }
    }

    /**
     * revives a player.
     */
    public void revive() {
        this.dead = false;
    }

    /**
     * method for the level up.
     */
    public void getXp(final int figherlevel) {
        this.xp += Math.max(0, PlayersConstants.MAX_XP_GAINED - (this.level - figherlevel)
                * PlayersConstants.XP_MODIFIER);
        calculatelevel();
    }

    /**
     * level up for a hero( angelxp ).
     */
    public void nextlevelxp() {
        int desiredxp = 0;
        if (this.level == 0) {
            desiredxp = AngelsConstants.VARIABLE_AUX250 - this.xp;
            this.xp += desiredxp;
            calculatelevel();
        } else {
            int thatxp = AngelsConstants.VARIABLE_AUX250
                    + this.level * AngelsConstants.VARIABLE_AUX50;
            desiredxp = thatxp - this.xp;
            this.xp += desiredxp;
            calculatelevel();
        }
    }

    /**
     * calculates the level after xp.
     */
    public void calculatelevel() {
        int localLevel = 0;
        int localXp = this.xp;
        while (localXp >= PlayersConstants.LEVEL_MODIFIER) {
            if (localLevel == 0) {
                if (localXp >= PlayersConstants.LIMIT_XP) {
                    localXp -= PlayersConstants.LIMIT_XP;
                    localLevel++;
                } else {
                    localXp = 0;
                }
            } else {
                localXp -= PlayersConstants.LEVEL_MODIFIER;
                localLevel++;
            }
        }
        if (localLevel > this.level) {
            for (int i = this.level + 1; i <= localLevel; i++) {
                String aux = this.getNickname() + " " + this.getId()
                        + " " + "reached" + " " + "level" + " " + i;
                this.notifyAllObservers(aux);
            }
            this.level = localLevel;
            getMaxHpmodify();
            this.hp = this.maxHp;
        }
        this.level = localLevel;

    }

    /**
     * @param hp
     */
    public void addhp(final int hp) {
        this.hp += hp;
        if (this.hp > this.maxHp)
            this.hp = this.maxHp;
    }

    /**
     * modify the maxHp after level up.
     */
    public void getMaxHpmodify() {
        if (this.name.equals("W")) {
            this.maxHp = WizardConstants.INITIAL_HP + this.level * WizardConstants.HP_PLUS;
        }
        if (this.name.equals("P")) {
            this.maxHp = PyromancerConstants.INITIAL_HP + this.level * PyromancerConstants.HP_PLUS;
        }
        if (this.name.equals("R")) {
            this.maxHp = RogueConstants.INITIAL_HP + this.level * RogueConstants.HP_PLUS;
        }
        if (this.name.equals("K")) {
            this.maxHp = KnightConstants.INITIAL_HP + this.level * KnightConstants.HP_PLUS;
        }
    }

    /**
     * getter for xp modifier.
     */
    public int getModifier() {
        int sol = 0;
        String a = new String("W");
        if (this.name.equals("W")) {
            sol = PlayersConstants.THIRTY_VALUE;
        }
        if (this.name.equals("P")) {
            sol = PlayersConstants.FIFTY_VALUE;
        }
        if (this.name.equals("R")) {
            sol = PlayersConstants.FOURTY_VALUE;
        }
        if (this.name.equals("K")) {
            sol = PlayersConstants.EIGHTY_VALUE;
        }
        return sol;
    }

    /**
     * setter for the level.
     */
    public void setLevel(final int levell) {
        this.level = levell;
    }

    /**
     * setter for the number of immobilized rounds.
     */
    public void setImmobile(final int immobilee) {
        this.immobile = immobilee;
    }

    /**
     * setter for the hp points.
     */
    public void setHp(final int hpp) {
        this.hp = hpp;
        // if( this.hp > this.maxHp)
        //   this.hp = this.maxHp;
    }

    /**
     * setter for the name of a player.
     */
    public void setName(final String namee) {
        this.name = namee;
        if (namee.equals("R")) {
            this.nickname = "Rogue";
        } else if (namee.equals("W")) {
            this.nickname = "Wizard";
        } else if (namee.equals("K")) {
            this.nickname = "Knight";
        } else if (namee.equals("P")) {
            this.nickname = "Pyromancer";
        }

    }

    /**
     * setter for the maxhp of a player.
     */
    public void setMaxHp(final int maxHpp) {
        this.maxHp = maxHpp;
    }

    /**
     * setter for status of the player.
     */
    public void setDead(final boolean deadd) {
        this.dead = deadd;
    }

    /**
     * setter for the position in the map.
     */
    public void setPosition(final Pair<Integer, Integer> positionn) {
        this.position = positionn;
    }

    /**
     * the damage for extra rounds.
     */
    public void getOvertimeDamage() {
        if (this.checkalive()) {
            if (this.passivecattacks != 0) {
                this.hp -= this.passiveDamage;
                this.passivecattacks--;
                if (this.hp <= 0) {
                    this.dead = true;
                }
            }
        }

    }

    /**
     * @param damage
     */
    public void getRoundDamage(final int damage) {
        this.hp -= damage;
        if (this.hp <= 0) {
            this.dead = true;
        }
    }

    /**
     * @param damage
     */
    public void substractHp(final int damage) {
        this.hp -= damage;
        if (this.hp <= 0) {
            this.dead = true;
            String aux = "Player" + " " + this.getNickname() + " " + this.getId() + " " + "was killed by an angel";
            this.notifyAllObservers(aux);
        }

    }

    /**
     * @param newvalue
     * @param overtime
     */
    public void setOvertimeDamage(final int newvalue, final int overtime) {
        this.passivecattacks = newvalue;
        this.passiveDamage = overtime;
    }

    public abstract void accept(Ability power);

    public abstract void accept1(Angels myangel);

    public abstract Ability heroAbility();

    public abstract void chooseStrategy();

    public abstract void voidaddobserver(Observer yes);

    public abstract void notifyAllObservers(String mystring);

}
