package main;

import angels.Angels;

import java.util.ArrayList;
import java.util.Map;

public class GameInput {
    private final String[] matrix;
    private final String[] matrixmoves;
    private final ArrayList<Integer> assets;
    private final ArrayList<String> players;
    private final ArrayList<Pair<Integer, Integer>> playersposition;
    private final Map<Integer, ArrayList<Angels>> angelsrounds;

    GameInput() {
        matrix = null;
        matrixmoves = null;
        assets = null;
        players = null;
        playersposition = null;
        angelsrounds = null;
    }

    public GameInput(final ArrayList<Integer> myarray, final String[] mymatrix,
                     final ArrayList<String> myplayers,
                     final ArrayList<Pair<Integer, Integer>> mypairs, final String[] mymatrixmoves,
                     final Map<Integer, ArrayList<Angels>> angelsrounds) {
        matrix = mymatrix;
        assets = myarray;
        playersposition = mypairs;
        players = myplayers;
        matrixmoves = mymatrixmoves;
        this.angelsrounds = angelsrounds;
    }

    /**
     * returns the games moves.
     */
    public String[] getMatrix() {
        return matrix;
    }

    /**
     * @return
     */
    public Map<Integer, ArrayList<Angels>> getAngelsrounds() {
        return angelsrounds;
    }

    /**
     * dimension for map structure, number of players etc.
     */
    public ArrayList<Integer> getAssets() {
        return assets;
    }

    /**
     * getter for the players.
     */
    public ArrayList<String> getPlayers() {
        return players;
    }

    /**
     * getter for players positions.
     */
    public ArrayList<Pair<Integer, Integer>> getPlayersposition() {
        return playersposition;
    }

    /**
     * getter for players moves.
     */
    public String[] getMatrixmoves() {
        return matrixmoves;
    }

}
