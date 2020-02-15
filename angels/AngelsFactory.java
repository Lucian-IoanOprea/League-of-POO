package angels;

import main.Pair;

public abstract class AngelsFactory {

    public static Angels getAngels(final String mystring, final Pair<Integer, Integer> mypair) {
        switch (mystring) {
            case "DamageAngel":
                return new DamageAngel(mystring, mypair);
            case "DarkAngel":
                return new DarkAngel(mystring, mypair);
            case "Dracula":
                return new Dracula(mystring, mypair);
            case "GoodBoy":
                return new GoodBoy(mystring, mypair);
            case "LevelUpAngel":
                return new LevelUpAngel(mystring, mypair);
            case "LifeGiver":
                return new LifeGiver(mystring, mypair);
            case "SmallAngel":
                return new SmallAngel(mystring, mypair);
            case "Spawner":
                return new Spawner(mystring, mypair);
            case "TheDoomer":
                return new TheDoomer(mystring, mypair);
            case "XPAngel":
                return new XPAngel(mystring, mypair);
            default:
                return null;

        }
    }

}
