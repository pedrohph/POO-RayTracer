package Raytracer;

import java.lang.Math.*;

public class Equacao {

    double a, b, c;
    double delta;

    public Equacao(double x, double y, double z) {
        this.a = x;
        this.b = y;
        this.c = z;
        this.delta = (b * b) - (4 * a * c);
    }

    public boolean getDelta() {

        this.delta = (this.b * this.b) - (4 * this.a * this.c);

        if (this.delta >= 0) {
            return true;
        } else {
            return false;
        }

    }

    public double getT1() {

        double rd = Math.sqrt(this.delta);
        double t = (-b + rd) / (2 * this.a);

        return t;
    }

    public double getT2() {
        double rd = Math.sqrt(this.delta);
        double t = (-b - rd) / (2 * this.a);
        return t;
    }

}
