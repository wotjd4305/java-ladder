package nextstep.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class LadderRow {
    private List<Point> points;
    private final RandomDraw randomDraw;
    private final int PERSON_COUNT;

    private static final String COLUMN = "|" ;
    private static final String ROW = "-" ;

    public LadderRow(int personCount, RandomDraw randomDraw) {
        this.randomDraw = randomDraw;
        this.PERSON_COUNT = personCount;

        if (personCount == 0) {
            throw new IllegalArgumentException("사다리 게임에 참여하는 사람은 0명이 될 수 없습니다.");
        }

        points = new ArrayList<>();
        Point currentPoint = Point.createInstance(randomDraw);
        points.add(currentPoint);

        for (int i = 1; i < personCount; i++) {
            currentPoint = createPoint(i, currentPoint);
            points.add(currentPoint);
        }
    }

    private Point createPoint(int i, Point currentPoint) {
        if (i == PERSON_COUNT - 1) {
            return Point.lastInstance();
        }
        return Point.createInstance(currentPoint, randomDraw);
    }

    public String drawLadderRow() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ".repeat(PERSON_COUNT));

        points.stream()
                .map(this::drawLadderRowStem)
                .forEach(t -> {
                    stringBuilder.append(COLUMN);
                    stringBuilder.append(t);
                });
        return stringBuilder.toString();
    }

    public String drawLadderRowStem(Point point) {
        if (point.isRightConnected()) {
            return ROW.repeat(PERSON_COUNT);
        }
        return " ".repeat(PERSON_COUNT);
    }
}
