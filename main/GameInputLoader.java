package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import angels.Angels;
import angels.AngelsFactory;
import fileio.FileSystem;

public class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    /**
     * inputs of the game.
     */
    public GameInput load() {
        ArrayList<Integer> assets = new ArrayList<>();
        ArrayList<String> myplayers = new ArrayList<String>();
        ArrayList<Pair<Integer, Integer>> coordinates = new ArrayList<Pair<Integer, Integer>>();
        Map<Integer, ArrayList<Angels>> angelsrounds = new HashMap<Integer, ArrayList<Angels>>();
        int rounds = 0;
        int noplayers = 0;
        int dimension1 = 0;
        int dimension2 = 0;
        String[] matrix = new String[dimension1 + 1];
        String[] matrixmoves = new String[0];
        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);
            dimension1 = fs.nextInt();
            dimension2 = fs.nextInt();
            assets.add(dimension1);
            assets.add(dimension2);
            matrix = new String[dimension1 + 1];
            for (int i = 0; i < dimension1; i++) {
                matrix[i] = fs.nextWord();
            }
            noplayers = fs.nextInt();
            assets.add(noplayers);
            for (int i = 0; i < noplayers; i++) {
                String aux = fs.nextWord();
                int x = fs.nextInt();
                int y = fs.nextInt();
                Pair pairaux = new Pair(x, y);
                myplayers.add(aux);
                coordinates.add(pairaux);
            }
            rounds = fs.nextInt();
            assets.add(rounds);
            matrixmoves = new String[rounds];
            for (int i = 0; i < rounds; i++) {
                matrixmoves[i] = fs.nextWord();
            }
            for (int i = 0; i < rounds; i++) {
                int nrangels = fs.nextInt();
                ArrayList<Angels> myaux = new ArrayList<Angels>();
                for (int j = 0; j < nrangels; j++) {
                    String aux = fs.nextWord();
                    String[] parts = aux.split(",");
                    Pair<Integer, Integer> mypair = new Pair<Integer, Integer>(Integer.valueOf(parts[1]), Integer.valueOf(parts[2]));
                    myaux.add(AngelsFactory.getAngels(parts[0], mypair));
                }
                angelsrounds.put(i, myaux);
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return new GameInput(assets, matrix, myplayers, coordinates, matrixmoves, angelsrounds);
    }


}
