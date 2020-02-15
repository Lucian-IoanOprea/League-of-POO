package abilities;

import constants.RogueConstants;
import main.GameMap;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class RogueAbility implements Ability {
    private Rogue myRogue;
    private float ability1thisround = 0;
    private float ability2thisround = 0;
    private float ability2nextround = 0;

    public RogueAbility(final Rogue hero) {
        myRogue = hero;
    }

    /**
     * Rogue is attacking a Wizard.
     */
    public void visit(final Wizard hero) {
        GameMap mymap = GameMap.getInstance();
        ability1thisround = RogueConstants.BACKSTAB_DAMAGE
                + RogueConstants.BACKSTAB_PER_LEVEL * myRogue.getLevel();
        if ((myRogue.getBackstab() - 1) % RogueConstants.NUMBEROF_ATTACKS == 0) {
            if (mymap.coordinates(myRogue.getPosition()) == 'W') {
                ability1thisround *= RogueConstants.CRITICAL_MODIFIER;
            }
        }
        ability2thisround = RogueConstants.PARALYSIS_DAMAGE
                + RogueConstants.PARALYSIS_PER_LEVEL * myRogue.getLevel();
        ability2nextround = ability2thisround;
        int roundsAffected = RogueConstants.NUMBER_ROUNDS_MIN;
        if (mymap.coordinates(myRogue.getPosition()) == 'W') {
            roundsAffected = RogueConstants.NUMBER_ROUNDS_MAX;
        }
        ability1thisround *= myRogue.getBackstabWizard();
        ability2thisround *= myRogue.getParalysisWizard();
        ability2nextround *= myRogue.getParalysisWizard();
        if (mymap.coordinates(myRogue.getPosition()) == 'W') {
            ability1thisround *= RogueConstants.SPECIAL_LAND;
            ability2thisround *= RogueConstants.SPECIAL_LAND;
            ability2nextround *= RogueConstants.SPECIAL_LAND;
        }
        ability1thisround = Math.round(ability1thisround);
        ability2thisround = Math.round(ability2thisround);
        hero.getRoundDamage((int) Math.round(ability1thisround + ability2thisround));
        hero.setOvertimeDamage(roundsAffected, (int) Math.round(ability2nextround));
        hero.setImmobile(roundsAffected);
    }

    /**
     * Rogue is attacking a Rogue.
     */
    public void visit(final Rogue hero) {
        GameMap mymap = GameMap.getInstance();
        ability1thisround = RogueConstants.BACKSTAB_DAMAGE
                + RogueConstants.BACKSTAB_PER_LEVEL * myRogue.getLevel();
        if ((myRogue.getBackstab() - 1) % RogueConstants.NUMBEROF_ATTACKS == 0) {
            if (mymap.coordinates(myRogue.getPosition()) == 'W') {
                ability1thisround *= RogueConstants.CRITICAL_MODIFIER;
            }
        }
        ability2thisround = RogueConstants.PARALYSIS_DAMAGE
                + RogueConstants.PARALYSIS_PER_LEVEL * myRogue.getLevel();
        ability2nextround = ability2thisround;
        int roundsAffected = RogueConstants.NUMBER_ROUNDS_MIN;
        if (mymap.coordinates(myRogue.getPosition()) == 'W') {
            roundsAffected = RogueConstants.NUMBER_ROUNDS_MAX;
        }
        ability1thisround *= myRogue.getBackstabRogue();
        ability2thisround *= myRogue.getParalysisRogue();
        ability2nextround *= myRogue.getParalysisRogue();
        if (mymap.coordinates(myRogue.getPosition()) == 'W') {
            ability1thisround *= RogueConstants.SPECIAL_LAND;
            ability2thisround *= RogueConstants.SPECIAL_LAND;
            ability2nextround *= RogueConstants.SPECIAL_LAND;
        }
        ability1thisround = Math.round(ability1thisround);
        ability2thisround = Math.round(ability2thisround);
        hero.getRoundDamage((int) Math.round(ability1thisround + ability2thisround));
        hero.setOvertimeDamage(roundsAffected, (int) Math.round(ability2nextround));
        hero.setImmobile(roundsAffected);
    }

    /**
     * Rogue is attacking Knight.
     */
    public void visit(final Knight hero) {
        GameMap mymap = GameMap.getInstance();
        ability1thisround = RogueConstants.BACKSTAB_DAMAGE
                + RogueConstants.BACKSTAB_PER_LEVEL * myRogue.getLevel();
        if ((myRogue.getBackstab() - 1) % RogueConstants.NUMBEROF_ATTACKS == 0) {
            if (mymap.coordinates(myRogue.getPosition()) == 'W') {
                ability1thisround *= RogueConstants.CRITICAL_MODIFIER;
            }
        }
        ability2thisround = RogueConstants.PARALYSIS_DAMAGE
                + RogueConstants.PARALYSIS_PER_LEVEL * myRogue.getLevel();
        ability2nextround = ability2thisround;
        int roundsAffected = RogueConstants.NUMBER_ROUNDS_MIN;
        if (mymap.coordinates(myRogue.getPosition()) == 'W') {
            roundsAffected = RogueConstants.NUMBER_ROUNDS_MAX;
        }
        ability1thisround *= myRogue.getBackstabKnight();
        ability2thisround *= myRogue.getParalysisKnight();
        ability2nextround *= myRogue.getParalysisKnight();
        if (mymap.coordinates(myRogue.getPosition()) == 'W') {
            ability1thisround *= RogueConstants.SPECIAL_LAND;
            ability2thisround *= RogueConstants.SPECIAL_LAND;
            ability2nextround *= RogueConstants.SPECIAL_LAND;
        }
        ability1thisround = Math.round(ability1thisround);
        ability2thisround = Math.round(ability2thisround);
        hero.getRoundDamage((int) Math.round(ability1thisround + ability2thisround));
        hero.setOvertimeDamage(roundsAffected, (int) Math.round(ability2nextround));
        hero.setImmobile(roundsAffected);
    }

    /**
     * Rogue is attacking Pyromancer.
     */
    public void visit(final Pyromancer hero) {
        GameMap mymap = GameMap.getInstance();
        ability1thisround = RogueConstants.BACKSTAB_DAMAGE
                + RogueConstants.BACKSTAB_PER_LEVEL * myRogue.getLevel();
        if ((myRogue.getBackstab() - 1) % RogueConstants.NUMBEROF_ATTACKS == 0) {
            if (mymap.coordinates(myRogue.getPosition()) == 'W') {
                ability1thisround *= RogueConstants.CRITICAL_MODIFIER;
            }
        }
        ability2thisround = RogueConstants.PARALYSIS_DAMAGE
                + RogueConstants.PARALYSIS_PER_LEVEL * myRogue.getLevel();
        ability2nextround = ability2thisround;
        int roundsAffected = RogueConstants.NUMBER_ROUNDS_MIN;
        if (mymap.coordinates(myRogue.getPosition()) == 'W') {
            roundsAffected = RogueConstants.NUMBER_ROUNDS_MAX;
        }
        ability1thisround *= myRogue.getBackstabPyromancer();
        ability2thisround *= myRogue.getParalysisPyromancer();
        ability2nextround *= myRogue.getParalysisPyromancer();
        if (mymap.coordinates(myRogue.getPosition()) == 'W') {
            ability1thisround *= RogueConstants.SPECIAL_LAND;
            ability2thisround *= RogueConstants.SPECIAL_LAND;
            ability2nextround *= RogueConstants.SPECIAL_LAND;
        }
        ability1thisround = Math.round(ability1thisround);
        ability2thisround = Math.round(ability2thisround);
        hero.getRoundDamage((int) Math.round(ability1thisround + ability2thisround));
        hero.setOvertimeDamage(roundsAffected, (int) Math.round(ability2nextround));
        hero.setImmobile(roundsAffected);
    }
}
