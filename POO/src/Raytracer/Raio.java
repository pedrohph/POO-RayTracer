package Raytracer;

import Jama.Matrix;

public class Raio {

    public double[] origem = new double[3];
    public double[] direcao = new double[3];

//Construtor
    public Raio(double x, double y, double z, double dx, double dy, double dz) {
        this.origem[0] = x;
        this.origem[1] = y;
        this.origem[2] = z;

        this.direcao[0] = dx;
        this.direcao[1] = dy;
        this.direcao[2] = dz;
    }

    public Raio(Vetor o, Vetor d) {
        this.origem[0] = o.getX();
        this.origem[1] = o.getY();
        this.origem[2] = o.getZ();

        this.direcao[0] = d.getX();
        this.direcao[1] = d.getY();
        this.direcao[2] = d.getZ();
    }

    public Raio(double x, double y, double z, Vetor v) {
        this.origem[0] = x;
        this.origem[1] = y;
        this.origem[2] = z;

        this.direcao[0] = v.getX();
        this.direcao[1] = v.getY();
        this.direcao[2] = v.getZ();
    }

    public double getOrigem(int i) {
        return origem[i];
    }

    public double getDirecao(int i) {
        return direcao[i];
    }

    public Vetor normalizarRaio(Vetor u) {
        double quaseNorma = Math.pow(u.getX(), 2) + Math.pow(u.getY(), 2) + Math.pow(u.getZ(), 2);
        float norma = (float) Math.sqrt(quaseNorma);
        // devolve vetor normalizado
        u.setVetor(u.getX() / norma, u.getY() / norma, u.getZ() / norma);
        return u;
    }

}
