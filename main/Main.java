package main;

import java.io.File;
import java.io.PrintStream;

public final class Main {
    private Main() {

    }

    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        GameLogic logic = new GameLogic(gameInput);
      // logic.preparegame();
      // logic.startgame();
      // logic.display();
        try {
            PrintStream o = new PrintStream(new File(args[1]));
            System.setOut(o);
            logic.preparegame();
            logic.startgame();
            logic.display();

        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }



}

