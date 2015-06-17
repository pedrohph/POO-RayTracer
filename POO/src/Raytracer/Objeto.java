package Raytracer;

import Jama.*;

public abstract class Objeto {

    int[] cor_difusa = new int[3];
    int[] cor_especular = new int[3];
    double coef_de_brilho;
    double reflexo;

    public abstract Vetor getNormal(Vetor d);

    public abstract boolean intersecao(Raio raio, double t);

    public abstract double aplicarTransformacao(double m);

    public abstract double calculaIntersecao(Raio raio);

    public abstract int getCorDifusa(int i);

    public abstract int cor_especular(int i);

    public abstract double getBrilho();
    
    public abstract double getReflexo();

}
