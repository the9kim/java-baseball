package baseball.domain;

public class Nothing {

    boolean nothing;

    private Nothing(boolean nothing) {
        this.nothing = nothing;
    }

    public static Nothing of(boolean nothing) {
        return new Nothing(nothing);
    }

    public boolean checkNothing() {
        return nothing;
    }
}
