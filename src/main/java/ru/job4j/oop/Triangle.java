package ru.job4j.oop;
import static java.lang.Math.sqrt;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double semiPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;

    }

    public boolean exist(double ab, double ac, double bc) {
        boolean rsl;
        if (ab + ac > bc && ac + bc > ab && ab + bc > ac) {
            rsl = true;
        }
        else {
            rsl = false;
        }
        return rsl;
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        if (this.exist(ab, ac, bc)) {
            double p = semiPerimeter(ab, ac, bc);
            double s = sqrt(p * (p - ab) * (p - ac) * (p - bc));
                    rsl = s;
        }
        return rsl;
    }
}
