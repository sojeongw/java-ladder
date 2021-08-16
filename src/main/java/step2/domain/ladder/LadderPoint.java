package step2.domain.ladder;

import java.util.Random;
import java.util.function.Function;

public enum LadderPoint {
    LEFT(x -> x - 1, "----|\t"),
    RIGHT(x -> x + 1, "\t|---"),
    NONE(x -> x, "\t|\t");

    private final Function<Integer, Integer> move;
    private final String shape;

    LadderPoint(Function<Integer, Integer> move, String shape) {
        this.move = move;
        this.shape = shape;
    }

    public static LadderPoint makeRandomPoint(LadderPoint ladderPoint) {
        if (ladderPoint == RIGHT) return LadderPoint.LEFT;

        return values()[new Random().nextInt(2) + 1];
    }

    public int move(int x) {
        return move.apply(x);
    }

    @Override
    public String toString() {
        return shape;
    }
}
