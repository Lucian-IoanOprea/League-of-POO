package players;

import main.Pair;

public abstract  class PlayersFactory {
    public static Players getPlayer(final String playerName,
                                    final Pair<Integer, Integer> mypair) {
        switch (playerName) {
            case "W":
                return new Wizard(mypair);

            case "K":
                return new Knight(mypair);

            case "R":
                return new Rogue(mypair);

            case "P":
                return new Pyromancer(mypair);

            default:
                return null;
        }
    }
}
