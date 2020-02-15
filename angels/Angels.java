package angels;

import main.Observer;
import main.Pair;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

import java.util.ArrayList;
import java.util.List;

public abstract class Angels {


    private Pair<Integer, Integer> position;
    private String name;
    private List<Observer> observers;

    Angels() {

    }

    /**
     * @return name.
     */
    public String getName() {
        return name;
    }

    Angels(final String name, final Pair<Integer, Integer> mypair) {
        position = mypair;
        this.name = name;
        observers = new ArrayList<>();
    }

    /**
     * returns the position of an angel.
     */
    public Pair<Integer, Integer> getPosition() {
        return position;
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

    public abstract void visit1(Wizard hero);

    public abstract void visit1(Knight hero);

    public abstract void visit1(Pyromancer hero);

    public abstract void visit1(Rogue hero);

}
