package main;

/**
 * Class that implements a generic pair.
 * The first element is referenced as ‘first’ and the second element as ‘second’
 * and the order is fixed (first, second).
 * */
public final class Pair<T, K> {
    private T first;
    private K second;
    /**
     * Constructor.
     * @param first
     * @param second
     * */
    public Pair(final T first, final K second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Setter for the first element.
     * */
    public void setFirst(final T first) {
        this.first = first;
    }
    /**
     * Getter for the first element.
     **/
    public T getFirst() {
        return this.first;
    }

    /**
     * Setter for the second element.
     * */
    public void setSecond(final K second) {
        this.second = second;
    }
    /**
     * Getter for the second element.
     * */
    public K getSecond() {
        return this.second;
    }
}
