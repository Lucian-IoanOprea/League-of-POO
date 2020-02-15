package abilities;

import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public interface Strategy {

    void execute(Wizard hero);
    void execute(Knight hero);
    void execute(Pyromancer hero);
    void execute(Rogue hero);
}
