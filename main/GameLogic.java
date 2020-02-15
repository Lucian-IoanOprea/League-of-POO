package main;

import angels.Angels;
import constants.AngelsConstants;
import constants.StrategyConstants;
import players.Players;
import players.PlayersFactory;
import java.util.ArrayList;
import java.util.Map;

public class GameLogic {
    private GameInput mygameinput;
    private ArrayList<Players> myplayers = new ArrayList<Players>(AngelsConstants.VARIABLE_AUX25);
    private int norounds = 0;
    private String[] moves;

    GameLogic(final GameInput game) {
        mygameinput = game;
    }

    /**
     * method for initializing the input.
     */
    public void preparegame() {
        ArrayList<Integer> auxiliary = mygameinput.getAssets();
        ArrayList<String> NAMES = mygameinput.getPlayers();
        ArrayList<Pair<Integer, Integer>> positions = mygameinput.getPlayersposition();
        TheGreatMagician magician = TheGreatMagician.getInstance();
        norounds = auxiliary.get(StrategyConstants.VARIABLE_AUX3);
        moves = mygameinput.getMatrixmoves();
        for (int i = 0; i < NAMES.size(); i++) {
            myplayers.add(PlayersFactory.getPlayer(NAMES.get(i), positions.get(i)));
            myplayers.get(i).setName(NAMES.get(i));
            myplayers.get(i).voidaddobserver(magician);
            myplayers.get(i).setId(i);
        }

        GameMap mymap = GameMap.getInstance();
        mymap.makemap(auxiliary.get(0), auxiliary.get(1), mygameinput.getMatrix());
    }

    /**
     * method for making the moves and fights.
     */
    public void startgame() {
        int x = 0;
        int y = 0;
        Map<Integer, ArrayList<Angels>> angelsrounds = mygameinput.getAngelsrounds();
        TheGreatMagician magician = TheGreatMagician.getInstance();
        for (int i = 0; i < norounds; i++) {
            System.out.println("~~ Round" + " " + (i + 1) + " " + "~~");
            if (i != 0) {
                for (Players k : myplayers) {
                    k.getOvertimeDamage();
                }
            }
            for (int j = 0; j < myplayers.size(); j++) {
                if (myplayers.get(j).checkalive()) {
                    if (myplayers.get(j).getImmobile() == 0) {
                        myplayers.get(j).chooseStrategy();
                    }
                    x = myplayers.get(j).getPosition().getFirst();
                    y = myplayers.get(j).getPosition().getSecond();
                    if (moves[i].charAt(j) == 'U') {
                        if (myplayers.get(j).getImmobile() == 0) {
                            x--;
                        }
                        myplayers.get(j).update(x, y);
                    } else if (moves[i].charAt(j) == 'D') {
                        if (myplayers.get(j).getImmobile() == 0) {
                            x++;
                        }
                        myplayers.get(j).update(x, y);
                    } else if (moves[i].charAt(j) == 'L') {
                        if (myplayers.get(j).getImmobile() == 0) {
                            y--;
                        }
                        myplayers.get(j).update(x, y);
                    } else if (moves[i].charAt(j) == 'R') {
                        if (myplayers.get(j).getImmobile() == 0) {
                            y++;
                        }
                        myplayers.get(j).update(x, y);
                    }
                }
            }
            for (int j = 0; j < myplayers.size() - 1; j++) {
                for (int k = j + 1; k < myplayers.size(); k++) {
                    if (myplayers.get(j).checkalive()
                            && myplayers.get(k).checkalive()) {
                        if (myplayers.get(j).getPosition().getFirst()
                                == myplayers.get(k).getPosition().getFirst()
                                && myplayers.get(j).getPosition().getSecond()
                                == myplayers.get(k).getPosition().getSecond()) {
                            if (myplayers.get(k).getName().equals("R")) {
                                myplayers.get(k).accept(myplayers.get(j).heroAbility());
                                myplayers.get(j).accept(myplayers.get(k).heroAbility());
                            } else {
                                myplayers.get(j).accept(myplayers.get(k).heroAbility());
                                myplayers.get(k).accept(myplayers.get(j).heroAbility());
                            }
                            if (myplayers.get(j).checkalive()
                                    && !myplayers.get(k).checkalive()) {
                                String aux = "Player " + myplayers.get(k).getNickname() + " "
                                        + myplayers.get(k).getId()
                                        + " " + "was killed by" + " "
                                        + myplayers.get(j).getNickname() + " "
                                        + myplayers.get(j).getId();
                                myplayers.get(j).notifyAllObservers(aux);
                                myplayers.get(j).getXp(myplayers.get(k).getLevel());
                            }
                            if (myplayers.get(k).checkalive()
                                    && !myplayers.get(j).checkalive()) {
                                String aux = "Player "
                                        + myplayers.get(j).getNickname()
                                        + " "
                                        + myplayers.get(j).getId()
                                        + " " + "was killed by" + " "
                                        + myplayers.get(k).getNickname() + " "
                                        + myplayers.get(k).getId();
                                myplayers.get(k).notifyAllObservers(aux);
                                myplayers.get(k).getXp(myplayers.get(j).getLevel());
                            }
                            if (!myplayers.get(k).checkalive()
                                    && !myplayers.get(j).checkalive()) {
                                String aux = "Player " + myplayers.get(k).getNickname() + " "
                                        + myplayers.get(k).getId()
                                        + " " + "was killed by" + " "
                                        + myplayers.get(j).getNickname()
                                        + " " + myplayers.get(j).getId();
                                myplayers.get(k).notifyAllObservers(aux);
                                String aux1 = "Player " + myplayers.get(j).getNickname() + " "
                                        + myplayers.get(j).getId()
                                        + " " + "was killed by" + " "
                                        + myplayers.get(k).getNickname()
                                        + " "
                                        + myplayers.get(k).getId();
                                myplayers.get(j).notifyAllObservers(aux1);

                            }

                        }
                    }

                }

            }
            ArrayList<Angels> theangels = angelsrounds.get(i);
            if (theangels.size() != 0) {
                for (int j = 0; j < theangels.size(); j++) {
                    Pair<Integer, Integer> thepair = theangels.get(j).getPosition();
                    theangels.get(j).voidaddobserver(magician);
                    String aux = "Angel" + " " + theangels.get(j).getName() + " "
                            + "was spawned at" + " " + thepair.getFirst() + " " + thepair.getSecond();
                    theangels.get(j).notifyAllObservers(aux);
                    for (int k = 0; k < myplayers.size(); k++) {
                        if (thepair.getFirst() == myplayers.get(k).getPosition().getFirst()
                                && thepair.getSecond()
                                == myplayers.get(k).getPosition().getSecond()) {
                            myplayers.get(k).accept1(theangels.get(j));
                        }
                    }
                }
            }
            System.out.println(" ");
        }

    }

    /**
     * method for displaying the results.
     */
    public void display() {

        System.out.println("~~" + " " + "Results" + " " + "~~");
        for (Players p : myplayers) {
            if (p.checkalive()) {
                System.out.println(p.getName() + " " + p.getLevel() + " "
                        + p.getXp() + " " + p.getHp() + " " + p.getPosition().getFirst()
                        + " " + p.getPosition().getSecond());
            } else {
                System.out.println(p.getName() + " " + "dead");
            }

        }

    }


}

