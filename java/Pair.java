package trick;

public class Pair<E, F>{
    private E one;
    private F two;
    public Pair(E one, F two) {
        this.one = one;
        this.two = two;
    }
    public E getOne() {
        return one;
    }
    public void setOne(E one) {
        this.one = one;
    }
    public F getTwo() {
        return two;
    }
    public void setTwo(F two) {
        this.two = two;
    }
}
