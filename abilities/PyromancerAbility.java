package abilities;

import constants.PyromancerConstants;
import main.GameMap;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class PyromancerAbility implements Ability {
    private Pyromancer myPyromancer;
    private float ability1damage;
    private float ability2thisround;
    private float ability2nextround;
    public PyromancerAbility(final Pyromancer hero) {
        myPyromancer = hero;
    }

    /**
     * Pyromancer is attacking a wizard.
     */
    public void visit(final Wizard hero) {
        ability1damage = (PyromancerConstants.FIRE_BLAST_DAMAGE
                + PyromancerConstants.FIRE_BLAST_ADDPERLEVEL * myPyromancer.getLevel());
        GameMap mymap = GameMap.getInstance();
        ability2thisround = PyromancerConstants.IGNITE_DAMAGETHISROUND
                + PyromancerConstants.IGNITE_ADDPERLEVEL_CURRENT * myPyromancer.getLevel();
        ability2nextround = PyromancerConstants.IGNITE_DAMAGE_NEXTROUNDS
                + PyromancerConstants.IGNITE_ADDPERLEVEL_NEXT * myPyromancer.getLevel();
        ability1damage *=  myPyromancer.getWizardModify();
        ability2thisround *= myPyromancer.getWizardModify();
        ability2nextround *= myPyromancer.getWizardModify();
        float totaldamage = Math.round(ability1damage + ability2thisround);
        ability2nextround = Math.round(ability2nextround);
        if (mymap.coordinates(myPyromancer.getPosition()) == 'V') {
            totaldamage *= PyromancerConstants.SPECIAL_LAND;
            ability2nextround *= PyromancerConstants.SPECIAL_LAND;
        }
        hero.getRoundDamage((int) Math.round(totaldamage));
        hero.setOvertimeDamage(2, (int) Math.round(ability2nextround));
    }

    /**
     * Pyromancer is attacking a Rogue.
     */
    public void visit(final Rogue hero) {
        ability1damage = (PyromancerConstants.FIRE_BLAST_DAMAGE
                + PyromancerConstants.FIRE_BLAST_ADDPERLEVEL * myPyromancer.getLevel());
        GameMap mymap = GameMap.getInstance();
        ability2thisround = PyromancerConstants.IGNITE_DAMAGETHISROUND
                + PyromancerConstants.IGNITE_ADDPERLEVEL_CURRENT * myPyromancer.getLevel();
        ability2nextround = PyromancerConstants.IGNITE_DAMAGE_NEXTROUNDS
                + PyromancerConstants.IGNITE_ADDPERLEVEL_NEXT * myPyromancer.getLevel();
        ability1damage *=  myPyromancer.getRogueModify();
        ability2thisround *= myPyromancer.getRogueModify();
        ability2nextround *= myPyromancer.getRogueModify();
        float totaldamage = Math.round(ability1damage + ability2thisround);
        ability2nextround = Math.round(ability2nextround);
        if (mymap.coordinates(myPyromancer.getPosition()) == 'V') {
            totaldamage *= PyromancerConstants.SPECIAL_LAND;
            ability2nextround *= PyromancerConstants.SPECIAL_LAND;
        }
        hero.getRoundDamage((int) Math.round(totaldamage));
        hero.setOvertimeDamage(2, (int) Math.round(ability2nextround));
    }

    /**
     * Pyromancer is attacking a Knight.
     */
    public void visit(final Knight hero) {
        ability1damage = (PyromancerConstants.FIRE_BLAST_DAMAGE
                + PyromancerConstants.FIRE_BLAST_ADDPERLEVEL * myPyromancer.getLevel());
        GameMap mymap = GameMap.getInstance();
        ability2thisround = PyromancerConstants.IGNITE_DAMAGETHISROUND
                + PyromancerConstants.IGNITE_ADDPERLEVEL_CURRENT * myPyromancer.getLevel();
        ability2nextround = PyromancerConstants.IGNITE_DAMAGE_NEXTROUNDS
                + PyromancerConstants.IGNITE_ADDPERLEVEL_NEXT * myPyromancer.getLevel();
        if (mymap.coordinates(myPyromancer.getPosition()) == 'V') {
            ability1damage *= PyromancerConstants.SPECIAL_LAND;
            ability2nextround *= PyromancerConstants.SPECIAL_LAND;
            ability2thisround *= PyromancerConstants.SPECIAL_LAND;
        }
        ability1damage = Math.round(ability1damage);
        ability2thisround = Math.round(ability2thisround);
       ability2nextround = Math.round(ability2nextround);
        ability1damage *=  myPyromancer.getKnightModify();
        ability2thisround *= myPyromancer.getKnightModify();
        ability2nextround *= myPyromancer.getKnightModify();
        ability1damage = Math.round(ability1damage);
        ability2thisround = Math.round(ability2thisround);
        ability2nextround = Math.round(ability2nextround);
        float totaldamage = Math.round(ability1damage + ability2thisround);
        ability2nextround = Math.round(ability2nextround);

        hero.getRoundDamage((int) Math.round(totaldamage));
        hero.setOvertimeDamage(2, (int) Math.round(ability2nextround));
    }

    /**
     * Pyromances is attacking a Pyromancer.
     */
    public void visit(final Pyromancer hero) {
        ability1damage = (PyromancerConstants.FIRE_BLAST_DAMAGE
                + PyromancerConstants.FIRE_BLAST_ADDPERLEVEL * myPyromancer.getLevel());
        GameMap mymap = GameMap.getInstance();
        ability2thisround = PyromancerConstants.IGNITE_DAMAGETHISROUND
                + PyromancerConstants.IGNITE_ADDPERLEVEL_CURRENT * myPyromancer.getLevel();
        ability2nextround = PyromancerConstants.IGNITE_DAMAGE_NEXTROUNDS
                + PyromancerConstants.IGNITE_ADDPERLEVEL_NEXT * myPyromancer.getLevel();
        if (mymap.coordinates(myPyromancer.getPosition()) == 'V') {
            ability2thisround *= PyromancerConstants.SPECIAL_LAND;
            ability1damage *= PyromancerConstants.SPECIAL_LAND;
            ability2nextround *= PyromancerConstants.SPECIAL_LAND;
        }
        ability1damage *=  myPyromancer.getPyroModify();
        ability2thisround *= myPyromancer.getPyroModify();
        ability2nextround *= myPyromancer.getPyroModify();
        float totaldamage = Math.round(ability1damage + ability2thisround);
        ability2nextround = Math.round(ability2nextround);

        hero.getRoundDamage((int) Math.round(totaldamage));
        hero.setOvertimeDamage(2, (int) Math.round(ability2nextround));
    }
}
