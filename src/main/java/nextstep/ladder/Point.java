package nextstep.ladder;

public class Point {
    private final boolean leftConnected;
    private final boolean rightConnected;

    private final boolean leftConnectable;
    private final boolean rightConnectable;

    public static Point createInstance(Point currentPoint, RandomDraw randomDraw) {
        return currentPoint.next(randomDraw);
    }

    public static Point createInstance(RandomDraw randomDraw) {
        return firstPoint(randomDraw);
    }

    public static Point lastInstance() {
        return lastPoint();
    }

    private static Point firstPoint(DrawablePolicy drawable) {
        return new Point(false, true, false, drawable.draw());
    }

    private static Point lastPoint() {
        return new Point(false, false, false, false);
    }

    private Point next(DrawablePolicy drawable) {
        if (isRightConnected()) {
            return new Point(true, false, false, false);
        }
        if (drawable.draw()) {
            return new Point(false, true, false, true);
        }
        return new Point(false, false, false, false);
    }


    public Point(boolean leftConnectable, boolean rightConnectable, boolean leftConnected, boolean rightConnected) {
        this.leftConnected = leftConnected;
        this.rightConnected = rightConnected;
        this.leftConnectable = leftConnectable;
        this.rightConnectable = rightConnectable;
    }

    public boolean isLeftConnected() {
        return leftConnected;
    }

    public boolean isRightConnected() {
        return rightConnected;
    }
}
