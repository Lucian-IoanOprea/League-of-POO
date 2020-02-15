package main;

public final class TheGreatMagician implements Observer {

    private static TheGreatMagician mymagician = null;
    private boolean created;

    private TheGreatMagician() {
        created = true;
    }

    public static TheGreatMagician getInstance() {
        if (mymagician == null) {
            return new TheGreatMagician();
        }
        return mymagician;
    }

    @Override
    public void update(final String mystring) {
        System.out.println(mystring);
    }
}
