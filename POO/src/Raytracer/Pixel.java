package Raytracer;

public class Pixel {

    public double x, y;

    public Pixel() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Pixel(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setPixel(double nX, double nY) {
        this.x = nX;
        this.y = nY;
    }

}
