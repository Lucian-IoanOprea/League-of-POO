package abilities;

import constants.*;
import main.GameMap;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;


public class WizardAbility implements Ability {
    private Wizard mywiz;
    private float ability1damage = 0;
    private float ability1percentage = 0;
    private float ability2percentage = 0;
    private float fighterpower = 0;

    public WizardAbility(final Wizard hero) {
        mywiz = hero;
    }

    /**
     * Wizard attacking a wizard.
     */
    public void visit(final Wizard hero) {
        GameMap mymap = GameMap.getInstance();
        ability1percentage = WizardConstants.DRAIN_DAMAGE
                + WizardConstants.DRAIN_PER_LEVEL * mywiz.getLevel();
        float baseHp = (float) Math.min(WizardConstants.MAX_HP_MODIFIER * (float) hero.getMaxHp(),
                (float) hero.getHp());
        baseHp = Math.round(baseHp);
        ability1percentage *= mywiz.getDrainWizard();
        ability1percentage /= PlayersConstants.ONE_HUNDREAD;
        ability1damage = baseHp * ability1percentage;
        if (mymap.coordinates(mywiz.getPosition()) == 'D') {
            ability1damage *= WizardConstants.SPECIAL_LAND;
        }
        ability1damage = Math.round(ability1damage);
        hero.getRoundDamage((int) Math.round(ability1damage));
    }

    /**
     * Wizard attacking a Rogue.
     */
    public void visit(final Rogue hero) {
        GameMap mymap = GameMap.getInstance();
        ability1percentage = WizardConstants.DRAIN_DAMAGE
                + WizardConstants.DRAIN_PER_LEVEL * mywiz.getLevel();
        float baseHp = (float) Math.min(WizardConstants.MAX_HP_MODIFIER * (float) hero.getMaxHp(),
                (float) hero.getHp());
        ability1percentage *= mywiz.getDrainRogue();

        ability1percentage /= PlayersConstants.ONE_HUNDREAD;
        ability1damage = baseHp * ability1percentage;
        if (mymap.coordinates(mywiz.getPosition()) == 'D') {
            ability1damage *= WizardConstants.SPECIAL_LAND;
        }
        ability1damage = Math.round(ability1damage);
        ability2percentage = WizardConstants.DEFLECT_Damage
                + mywiz.getLevel() * WizardConstants.DEFLECT_PER_LEVEL;
        if (ability2percentage > WizardConstants.MAX_PROCENT) {
            ability2percentage = WizardConstants.MAX_PROCENT;
        }
        ability2percentage /= PlayersConstants.ONE_HUNDREAD;
        fighterpower = RogueConstants.BACKSTAB_DAMAGE
                + RogueConstants.BACKSTAB_PER_LEVEL * hero.getLevel();
        if (mymap.coordinates(mywiz.getPosition()) == 'W' && (hero.getBackstab())
                % RogueConstants.NUMBEROF_ATTACKS == 0) {
            fighterpower *= RogueConstants.CRITICAL_MODIFIER;
        }
        fighterpower += RogueConstants.PARALYSIS_DAMAGE
                + RogueConstants.PARALYSIS_PER_LEVEL * hero.getLevel();
        if (mymap.coordinates(mywiz.getPosition()) == 'W') {
            fighterpower *= RogueConstants.SPECIAL_LAND;
        }
        ability2percentage *= mywiz.getDeflectRogue();
        float deflectfromfighter = ability2percentage * fighterpower;
        if (mymap.coordinates(mywiz.getPosition()) == 'D') {
            deflectfromfighter *= WizardConstants.SPECIAL_LAND;
        }
     //   System.out.println(mywiz.DRAIN_ROGUE+" "+mywiz.DEFLECT_ROGUE);
     //   System.out.println(ability1damage+" "+deflectfromfighter);
        deflectfromfighter = Math.round(deflectfromfighter);
        hero.getRoundDamage((int) Math.round(deflectfromfighter + ability1damage));
    }

    /**
     * Wizard attacking Knight.
     */
    public void visit(final Knight hero) {
        GameMap mymap = GameMap.getInstance();
        ability1percentage = WizardConstants.DRAIN_DAMAGE
                + WizardConstants.DRAIN_PER_LEVEL * mywiz.getLevel();
        float baseHp = (float) Math.min(WizardConstants.MAX_HP_MODIFIER * (float) hero.getMaxHp(),
                (float) hero.getHp());
        ability1percentage *= mywiz.getDrainKnight();
        ability1percentage /= PlayersConstants.ONE_HUNDREAD;
        ability1damage = baseHp * ability1percentage;
        if (mymap.coordinates(mywiz.getPosition())  == 'D') {
            ability1damage *= WizardConstants.SPECIAL_LAND;
        }
        ability1damage = Math.round(ability1damage);
        ability2percentage = WizardConstants.DEFLECT_Damage + mywiz.getLevel()
                * WizardConstants.DEFLECT_PER_LEVEL;
        if (ability2percentage > WizardConstants.MAX_PROCENT) {
            ability2percentage = WizardConstants.MAX_PROCENT;
        }
        ability2percentage /= PlayersConstants.ONE_HUNDREAD;
        float hptillexecution = KnightConstants.MAX_HP_MODIFY * (float) mywiz.getMaxHp();
        if (hero.getLevel() < KnightConstants.EXECUTE_MAX_LEVEL) {
            hptillexecution += ((float) hero.getLevel() / (float) PlayersConstants.ONE_HUNDREAD)
                    * (float) mywiz.getMaxHp();
        } else {
            hptillexecution += KnightConstants.EXECUTE_HP_MODIFY * (float) mywiz.getMaxHp();
        }
        int flag = 0;
        if ((float) mywiz.getHp() < hptillexecution && mywiz.getHp() > 0) {
            fighterpower = mywiz.getHp();
            flag = 1;
        }
            fighterpower = KnightConstants.EXECUTE_DAMAGE
                    + KnightConstants.EXECUTE_PER_LEVEL * hero.getLevel();
            fighterpower += (KnightConstants.SLAM_DAMAGE
                    + KnightConstants.SLAM_PER_LEVEL * hero.getLevel());

        if (mymap.coordinates(mywiz.getPosition()) == 'L' && flag != 1) {
            fighterpower *= KnightConstants.SPECIAL_LAND;
        }
        ability2percentage *= mywiz.getDeflectKnight();
        float deflectfromfighter = ability2percentage * fighterpower;
        if (mymap.coordinates(mywiz.getPosition()) == 'D') {
            deflectfromfighter *= WizardConstants.SPECIAL_LAND;
        }
        deflectfromfighter = Math.round(deflectfromfighter);
        hero.getRoundDamage((int) Math.round(deflectfromfighter + ability1damage));
    }

    /**
     * Wizard attacking a Pyromancer.
     */
    public void visit(final Pyromancer hero) {
        GameMap mymap = GameMap.getInstance();
        ability1percentage = WizardConstants.DRAIN_DAMAGE
                + WizardConstants.DRAIN_PER_LEVEL * mywiz.getLevel();
        float baseHp = (float) Math.min(WizardConstants.MAX_HP_MODIFIER * (float) hero.getMaxHp(),
                (float) hero.getHp());
        ability1percentage *= mywiz.getDrainPyromancer();
        ability1percentage /= PlayersConstants.ONE_HUNDREAD;
       // System.out.println(ability1percentage);
        ability1damage = baseHp * ability1percentage;
        if (mymap.coordinates(mywiz.getPosition()) == 'D') {
            ability1damage *= WizardConstants.SPECIAL_LAND;
        }
        ability1damage = Math.round(ability1damage);
        ability2percentage = WizardConstants.DEFLECT_Damage
                + mywiz.getLevel() * WizardConstants.DEFLECT_PER_LEVEL;
        if (ability2percentage > WizardConstants.MAX_PROCENT) {
            ability2percentage = WizardConstants.MAX_PROCENT;
        }
        ability2percentage /= PlayersConstants.ONE_HUNDREAD;
        float ability1 = PyromancerConstants.FIRE_BLAST_DAMAGE
                + PyromancerConstants.FIRE_BLAST_ADDPERLEVEL * hero.getLevel();
        float ability2 = PyromancerConstants.IGNITE_DAMAGETHISROUND
                + PyromancerConstants.IGNITE_ADDPERLEVEL_CURRENT * hero.getLevel();
        if (mymap.coordinates(mywiz.getPosition()) == 'V') {
            ability1 *= PyromancerConstants.SPECIAL_LAND;
            ability2 *= PyromancerConstants.SPECIAL_LAND;
        }
        fighterpower = Math.round(ability1) + Math.round(ability2);
        ability2percentage *= mywiz.getDeflectPyromancer();
        float deflectfromfighter = ability2percentage * fighterpower;
        if (mymap.coordinates(mywiz.getPosition()) == 'D') {
            deflectfromfighter *= WizardConstants.SPECIAL_LAND;
        }
        deflectfromfighter = Math.round(deflectfromfighter);
        hero.getRoundDamage((int) Math.round(deflectfromfighter + ability1damage));
    }

}
