package Raytracer;

import java.lang.Math.*;
/**Clase para calcular equação de segundo grau
 * 
 * @author Pedro H
 * @version 1.0.0
 */

public class Equacao {

    double a, b, c;
    double delta;

    /**Construtor
     * 
     * @param x - Equivalente a 'a' na equação de segundo grau
     * @param y - Equivalente a 'b' na equação de segundo grau
     * @param z - Equivalente a 'c' na equação de segundo grau
     */
    public Equacao(double x, double y, double z) {
        this.a = x;
        this.b = y;
        this.c = z;
        this.delta = (b * b) - (4 * a * c);
    }

    /**Método getDelta
     * 
     * @return boolean - Caso delta seja possivel de se calcular retorna true, caso não false
     */
    public boolean getDelta() {

        this.delta = (this.b * this.b) - (4 * this.a * this.c);

        if (this.delta >= 0) {
            return true;
        } else {
            return false;
        }

    }

    /**Método getT1
     * 
     * @return double - Referente a "X1" da equação de segundo grau
     */
    public double getT1() {

        double rd = Math.sqrt(this.delta);
        double t = (-b + rd) / (2 * this.a);

        return t;
    }

    /**Método getT2
     * 
     * @return double - Referente a "X2" da equação de segundo grau
     */
    public double getT2() {
        double rd = Math.sqrt(this.delta);
        double t = (-b - rd) / (2 * this.a);
        return t;
    }

}
