package ladder.domain.ladder;

import ladder.domain.strategy.LineStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int countOfPerson, int ladderHeight, LineStrategy lineStrategy) {
        validate(ladderHeight);
        return IntStream.range(0, ladderHeight)
                .mapToObj(i -> Line.of(countOfPerson, lineStrategy))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ladder::new));
    }

    private static void validate(int ladderHeight) {
        if (ladderHeight < 0) {
            throw new IllegalArgumentException("Ladder height must be positive.");
        }
    }

    public Line get(int index) {
        return lines.get(index);
    }

    public int height() {
        return lines.size();
    }

    public Stream<Line> stream() {
        return lines.stream();
    }
}