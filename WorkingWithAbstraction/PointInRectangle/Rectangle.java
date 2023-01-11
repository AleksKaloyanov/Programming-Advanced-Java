package WorkingWithAbstraction.PointInRectangle;

public class Rectangle {
    private Point2D a;

    private Point2D c;

    public Rectangle(Point2D a, Point2D c) {
        this.a = a;
        this.c = c;
    }


    public boolean contains(Point2D target) {
        return this.a.getX() <= target.getX() && this.a.getY() <= target.getY()
                && this.c.getX() >= target.getX() && this.c.getY() >= target.getY();
    }
}
