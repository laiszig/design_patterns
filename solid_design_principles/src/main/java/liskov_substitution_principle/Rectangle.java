package liskov_substitution_principle;

/**
 - S is a subtype of T, then objects of type T may be replaced with objects of type S.
 - Derived types must be completely substitutable for their base types.
 - Liskov substitution Principle is a particular definition of a subtyping relation,
 called (strong) behavioral subtyping.

 - No new exceptions can be thrown by the subtype
 - Clients should not know which specific subtype they are calling
 - New derived classes just extend without replacing the functionality of old classes
 **/

public class Rectangle {

    protected int width, height;

    public Rectangle() {
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    public boolean isSquare() {
        return width == height;
    }
}

class Square extends Rectangle {
    public Square() {}
    public Square (int size) {
        width = height = size;
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}

class RectangleFactory {
    public static Rectangle newRectangle(int width, int height) {
        return new Rectangle(width, height);
    }
    public static Rectangle newSquare(int side) {
        return new Rectangle(side, side);
    }
}

class Demo {
    static void useIt(Rectangle r) {
        int width = r.getWidth();
        r.setHeight(10);
        //area = width * 10
        System.out.println(
                "Expected area of " + (width * 10) +
                        ", got " + r.getArea());
    }

    public static void main(String[] args) {
        Rectangle rc = new Rectangle(2, 3);
        useIt(rc);

        Rectangle sq = new Square();
        sq.setWidth(5);
        useIt(sq);
    }
}
