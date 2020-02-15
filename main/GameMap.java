package main;

public final class GameMap {
    private char[][] gamemap;
    private static final GameMap mapgame = new GameMap();
    private int n = 0;
    private int m = 0;
    private GameMap() {
        gamemap = new char[0][0];
    }

    /**
     * initializing the game map.
     */
    void makemap(final int nn, final int nm, final  String[] land) {
        this.n = nn;
        this.m = nn;
        gamemap = new char[this.n + 1][this.m + 1];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                gamemap[i][j] = land[i].charAt(j);
            }
        }
    }

    /**
     * Getter for the map.
     */
    public char[][] getGamemap() {
        return gamemap;
    }

    /**
     * return the type of the land for certain coordinates.
     */
    public char coordinates(final Pair<Integer, Integer> mypair) {
        return gamemap[mypair.getFirst()][mypair.getSecond()];
    }
    public static GameMap getInstance() {
        if (mapgame == null) {
            new GameMap();
        }
        return mapgame;
    }
}
