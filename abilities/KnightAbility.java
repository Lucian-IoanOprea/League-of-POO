package abilities;

import constants.KnightConstants;
import constants.PlayersConstants;
import main.GameMap;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class KnightAbility implements Ability {
    private Knight myKnight;
    private float ability1thisround = 0;
    private float ability2thisround = 0;

    public KnightAbility(final Knight hero) {
        myKnight = hero;
    }

    /**
     * Knight is attacking a wizard.
     */
    public void visit(final Wizard hero) {
        GameMap mymap = GameMap.getInstance();
        float hptillexecution = KnightConstants.MAX_HP_MODIFY * hero.getMaxHp();
        if (myKnight.getLevel() < KnightConstants.EXECUTE_MAX_LEVEL) {
            hptillexecution += ((float)
                    myKnight.getLevel() / PlayersConstants.ONE_HUNDREAD) * hero.getMaxHp();
        } else {
            hptillexecution += KnightConstants.EXECUTE_HP_MODIFY * hero.getMaxHp();
        }
        if ((float) hero.getHp() < hptillexecution && hero.getHp() > 0) {
            hero.getRoundDamage(hero.getHp());
        } else {
            ability1thisround = KnightConstants.EXECUTE_DAMAGE
                    + KnightConstants.EXECUTE_PER_LEVEL * myKnight.getLevel();
            ability2thisround = KnightConstants.SLAM_DAMAGE;
            ability2thisround += KnightConstants.SLAM_PER_LEVEL * myKnight.getLevel();
            ability1thisround *= myKnight.getWizardModifyA();
            ability2thisround *= myKnight.getWizardModifyB();
            float totaldamage;
            totaldamage = ability2thisround + ability1thisround;
            if (mymap.coordinates(myKnight.getPosition()) == 'L') {
                totaldamage *= KnightConstants.SPECIAL_LAND;
            }
            hero.getRoundDamage((int) Math.round(totaldamage));
            hero.setImmobile(1);
        }
    }

    /**
     * Knight is attacking a Rogue.
     */
    public void visit(final Rogue hero) {
        GameMap mymap = GameMap.getInstance();
        float hptillexecution = KnightConstants.MAX_HP_MODIFY * hero.getMaxHp();
        if (myKnight.getLevel() < KnightConstants.EXECUTE_MAX_LEVEL) {
            hptillexecution += ((float) myKnight.getLevel() / PlayersConstants.ONE_HUNDREAD)
                    * hero.getMaxHp();
        } else {
            hptillexecution += KnightConstants.EXECUTE_HP_MODIFY * hero.getMaxHp();
        }
        if ((float) hero.getHp() < hptillexecution && hero.getHp() > 0) {
            hero.getRoundDamage(hero.getHp());
        } else {
            ability1thisround = KnightConstants.EXECUTE_DAMAGE
                    + KnightConstants.EXECUTE_PER_LEVEL * myKnight.getLevel();
            ability2thisround = KnightConstants.SLAM_DAMAGE;
            ability2thisround += KnightConstants.SLAM_PER_LEVEL * myKnight.getLevel();
            ability1thisround *= myKnight.getRogueModifyA();
            ability2thisround *= myKnight.getRogueModifyB();
            float totaldamage;
            totaldamage = ability2thisround + ability1thisround;
            if (mymap.coordinates(myKnight.getPosition()) == 'L') {
                totaldamage *= KnightConstants.SPECIAL_LAND;
            }
            hero.getRoundDamage((int) Math.round(totaldamage));
            hero.setImmobile(1);
        }

    }

    /**
     * Knight is attacking a Knight.
     */
    public void visit(final Knight hero) {
        GameMap mymap = GameMap.getInstance();
        float hptillexecution = KnightConstants.MAX_HP_MODIFY * hero.getMaxHp();
        if (myKnight.getLevel() < KnightConstants.EXECUTE_MAX_LEVEL) {
            hptillexecution += ((float) myKnight.getLevel() / PlayersConstants.ONE_HUNDREAD)
                    * hero.getMaxHp();
        } else {
            hptillexecution += KnightConstants.EXECUTE_HP_MODIFY * hero.getMaxHp();
        }
        if ((float) hero.getHp() < hptillexecution && hero.getHp() > 0) {
            hero.getRoundDamage(hero.getHp());
        } else {
            ability1thisround = KnightConstants.EXECUTE_DAMAGE
                    + KnightConstants.EXECUTE_PER_LEVEL * myKnight.getLevel();
            ability2thisround = KnightConstants.SLAM_DAMAGE;
            ability2thisround += KnightConstants.SLAM_PER_LEVEL * myKnight.getLevel();
            ability1thisround *= myKnight.getKnightModifyA();
            ability2thisround *= myKnight.getKnightModifyB();
            float totaldamage;
            totaldamage = ability2thisround + ability1thisround;
            if (mymap.coordinates(myKnight.getPosition()) == 'L') {
                totaldamage *= KnightConstants.SPECIAL_LAND;
            }
            hero.getRoundDamage((int) Math.round(totaldamage));
            hero.setImmobile(1);
        }
    }

    /**
     * Knight is attacking a Pyromancer.
     */
    public void visit(final Pyromancer hero) {
        GameMap mymap = GameMap.getInstance();
        float hptillexecution = KnightConstants.MAX_HP_MODIFY * hero.getMaxHp();
        if (myKnight.getLevel() < KnightConstants.EXECUTE_MAX_LEVEL) {
            hptillexecution += ((float) myKnight.getLevel() / PlayersConstants.ONE_HUNDREAD)
                    * hero.getMaxHp();
        } else {
            hptillexecution += KnightConstants.EXECUTE_HP_MODIFY * hero.getMaxHp();
        }
        if ((float) hero.getHp() < hptillexecution && hero.getHp() > 0) {
            hero.getRoundDamage(hero.getHp());
        } else {
            ability1thisround = KnightConstants.EXECUTE_DAMAGE
                    + KnightConstants.EXECUTE_PER_LEVEL * myKnight.getLevel();
            ability2thisround = KnightConstants.SLAM_DAMAGE;
            ability2thisround += KnightConstants.SLAM_PER_LEVEL * myKnight.getLevel();
            ability1thisround *= myKnight.getPyroModifyA();
            ability2thisround *= myKnight.getPyroModifyB();
            float totaldamage;
            totaldamage = ability2thisround + ability1thisround;
            if (mymap.coordinates(myKnight.getPosition()) == 'L') {
                totaldamage *= KnightConstants.SPECIAL_LAND;
            }
            hero.getRoundDamage((int) Math.round(totaldamage));
            hero.setImmobile(1);
        }
    }
}
