package Raytracer;

import Jama.*;

public class Plano extends Objeto {

    double[] p = new double[3];
    int i = 0;

    @Override
    public Vetor getNormal(Vetor d) {
        return d;
    }

    @Override
    public boolean intersecao(Raio rraio, double t) {
        double xc = rraio.origem[0];
        double yc = rraio.origem[1];
        double zc = rraio.origem[2];
        double xd = rraio.direcao[0];
        double yd = rraio.direcao[1];
        double zd = rraio.direcao[2];

        this.p[0] = xc + xd * t;
        this.p[1] = yc + yd * t;
        this.p[2] = zc + zd * t;

        return true;
    }

    @Override
    public double calculaIntersecao(Raio r) {
        double normal = 0;
        return normal;
    }

    @Override
    public int getCorDifusa(int i) {
        return cor_difusa[i];
    }

    @Override
    public int cor_especular(int i) {
        return cor_especular[i];
    }

    @Override
    public double getBrilho() {
        return coef_de_brilho;
    }

    @Override
    public double aplicarTransformacao(double m) {
        return m;
    }

    public void setIndice(int i) {
        this.i = i;
    }

    @Override
    public double getReflexo() {
        return reflexo;
    }

    
}
