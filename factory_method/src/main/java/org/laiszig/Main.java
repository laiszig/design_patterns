package org.laiszig;

enum CoordinateSystem{
    CARTESIAN,
    POLAR
}

class Point {
    private double x, y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

public static class PointFactory { //factory class
    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y);
    }

    public static Point newPolarPoint(double rho, double theta) {
        return new Point(rho*Math.cos(theta),
                rho*Math.sin(theta));
    }
}

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

//    public Point(double rho, double theta) { you can't have two constructor with the same quantity && data type parameters
//        x = rho * Math.cos(theta);
//        y = rho * Math.sin(theta);
//    }

//    public Point(double a, double b, CoordinateSystem cs) {
//        switch (cs) {
//            case CARTESIAN:
//                this.x = x;
//                this.y = y;
//                break;
//            case POLAR:
//                x = a * Math.cos(b);
//                y = a * Math.sin(b);
//                break;
//        }

//    }
}
public class Main {
    public static void main(String[] args) {
        Point polarPoint = Point.PointFactory.newPolarPoint(2, 3);
        Point cartesianPoint = Point.PointFactory.newCartesianPoint(7, 99);

        System.out.println(polarPoint);
        System.out.println(cartesianPoint);
    }
}