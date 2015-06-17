package Raytracer;

import java.awt.*;
import Jama.*;

public class Triangulo extends Objeto {

    Vetor vA;
    Vetor vB;
    Vetor vC;

    public Triangulo(Vetor a, Vetor b, Vetor c, int cdr, int cdg, int cdb, int cer, int ceg, int ceb) {
        this.vA = new Vetor(a);
        this.vB = new Vetor(b);
        this.vC = new Vetor(c);

        this.cor_difusa[0] = cdr;
        this.cor_difusa[1] = cdg;
        this.cor_difusa[2] = cdb;

        this.cor_especular[0] = cer;
        this.cor_especular[1] = ceg;
        this.cor_especular[2] = ceb;
        
        coef_de_brilho = 1;
        reflexo = 0;

    }

    @Override
    public Vetor getNormal(Vetor d) {
        Vetor vX = vA.SubtraiVetor(vB);
        Vetor vY = vA.SubtraiVetor(vC);

        double i = (vX.getY() * vY.getZ()) - (vX.getZ() * vY.getY());
        double j = (vX.getZ() * vY.getX()) - (vX.getX() * vY.getZ());
        double k = (vX.getX() * vY.getY()) - (vX.getY() * vY.getX());

        Vetor resultado = new Vetor(i, j, k);

        return resultado;
    }

    @Override
    public double getBrilho() {
        return coef_de_brilho;
    }

    @Override
    public int cor_especular(int i) {
        return cor_especular[i];
    }

    @Override
    public int getCorDifusa(int i) {
        return cor_difusa[i];
    }

    @Override
    public double calculaIntersecao(Raio r) {
        /* Matrix u = new Matrix(3, 3);
        u.set(0, 0, (vA.getX()) - (r.getOrigem(0)));
        u.set(1, 0, (vA.getY()) - (r.getOrigem(1)));
        u.set(2, 0, (vA.getZ()) - (r.getOrigem(2)));
        u.set(0, 1, (vA.getX()) - (vC.getX()));
        u.set(1, 1, (vA.getY()) - (vC.getY()));
        u.set(2, 1, (vA.getZ()) - (vC.getZ()));
        u.set(0, 2, r.getDirecao(0));
        u.set(1, 2, r.getDirecao(1));
        u.set(2, 2, r.getDirecao(2));
        
        Matrix v = new Matrix(3, 3);
        v.set(0, 0, (vA.getX()) - (vB.getX()));
        v.set(1, 0, (vA.getY()) - (vB.getY()));
        v.set(2, 0, (vA.getZ()) - (vB.getZ()));
        v.set(0, 1, (vA.getX()) - (r.getOrigem(0)));
        v.set(1, 1, (vA.getY()) - (r.getOrigem(1)));
        v.set(2, 1, (vA.getZ()) - (r.getOrigem(2)));
        v.set(0, 2, r.getDirecao(0));
        v.set(1, 2, r.getDirecao(1));
        v.set(2, 2, r.getDirecao(2));
        
        Matrix a = new Matrix(3, 3);
        a.set(0, 0, (vA.getX()) - (vB.getX()));
        a.set(1, 0, (vA.getY()) - (vB.getY()));
        a.set(2, 0, (vA.getZ()) - (vB.getZ()));
        a.set(0, 1, (vA.getX()) - (vC.getX()));
        a.set(1, 1, (vA.getY()) - (vC.getY()));
        a.set(2, 1, (vA.getZ()) - (vC.getZ()));
        a.set(0, 2, r.getDirecao(0));
        a.set(1, 2, r.getDirecao(1));
        a.set(2, 2, r.getDirecao(2));
        
        Matrix t = new Matrix(3,3);
        t.set(0, 0, (vA.getX()) - (vB.getX()));
        t.set(1, 0, (vA.getY()) - (vB.getY()));
        t.set(2, 0, (vA.getZ()) - (vB.getZ()));
        t.set(0, 1, (vA.getX()) - (vC.getX()));
        t.set(1, 1, (vA.getY()) - (vC.getY()));
        t.set(2, 1, (vA.getZ()) - (vC.getZ()));
        t.set(0, 2, (vA.getX()) - (r.getOrigem(0)));
        t.set(1, 2, (vA.getY()) - (r.getOrigem(1)));
        t.set(2, 2, (vA.getZ()) - (r.getOrigem(2)));
        
        double uf = u.det() / a.det();
        double vf = v.det() / a.det();
        double tf = t.det()/a.det();
        double soma = vA.getX()+ uf*((vB.getX() - vA.getX())) + vf*((vC.getX() - vA.getX()));
        */
        Vetor x = vB.SubtraiVetor(vA);
        Vetor y = vC.SubtraiVetor(vA);
        Vetor n = x.produtoVetorial(y);
        Vetor d = new Vetor(r.getDirecao(0),r.getDirecao(1),r.getDirecao(2));
        
        Matrix matriz = new Matrix(3, 3);
        matriz.set(0, 0, (r.getOrigem(0) - r.getDirecao(0)));
        matriz.set(1, 0, (r.getOrigem(1) - r.getDirecao(1)));
        matriz.set(2, 0, (r.getOrigem(2) - r.getDirecao(2)));
        matriz.set(0, 1, (vB.getX()) - (vA.getX()));
        matriz.set(1, 1, (vB.getY()) - (vA.getY()));
        matriz.set(2, 1, (vB.getZ()) - (vA.getZ()));
        matriz.set(0, 2, (vC.getX()) - (vA.getX()));
        matriz.set(1, 2, (vC.getY()) - (vA.getY()));
        matriz.set(2, 2, (vC.getZ()) - (vA.getZ()));
        
        Matrix coluna = new Matrix(3,1);
        coluna.set(0, 0, (r.getOrigem(0) - (vA.getX())));
        coluna.set(1, 0, (r.getOrigem(1) - (vA.getY())));
        coluna.set(2, 0, (r.getOrigem(2) - (vA.getZ())));
        
        matriz = matriz.inverse();
        
        Matrix fim = matriz.times(coluna);
        double soma = fim.get(0, 0);
        
        return soma;
    }

    @Override
    public boolean intersecao(Raio raio, double tt) {
        /* Matrix u = new Matrix(3, 3);
        u.set(0, 0, (vA.getX()) - (raio.getOrigem(0)));
        u.set(1, 0, (vA.getY()) - (raio.getOrigem(1)));
        u.set(2, 0, (vA.getZ()) - (raio.getOrigem(2)));
        u.set(0, 1, (vA.getX()) - (vC.getX()));
        u.set(1, 1, (vA.getY()) - (vC.getY()));
        u.set(2, 1, (vA.getZ()) - (vC.getZ()));
        u.set(0, 2, raio.getDirecao(0));
        u.set(1, 2, raio.getDirecao(1));
        u.set(2, 2, raio.getDirecao(2));
        
        
        Matrix v = new Matrix(3, 3);
        v.set(0, 0, (vA.getX()) - (vB.getX()));
        v.set(1, 0, (vA.getY()) - (vB.getY()));
        v.set(2, 0, (vA.getZ()) - (vB.getZ()));
        v.set(0, 1, (vA.getX()) - (raio.getOrigem(0)));
        v.set(1, 1, (vA.getY()) - (raio.getOrigem(1)));
        v.set(2, 1, (vA.getZ()) - (raio.getOrigem(2)));
        v.set(0, 2, raio.getDirecao(0));
        v.set(1, 2, raio.getDirecao(1));
        v.set(2, 2, raio.getDirecao(2));
        
        Matrix a = new Matrix(3, 3);
        a.set(0, 0, (vA.getX()) - (vB.getX()));
        a.set(1, 0, (vA.getY()) - (vB.getY()));
        a.set(2, 0, (vA.getZ()) - (vB.getZ()));
        a.set(0, 1, (vA.getX()) - (vC.getX()));
        a.set(1, 1, (vA.getY()) - (vC.getY()));
        a.set(2, 1, (vA.getZ()) - (vC.getZ()));
        a.set(0, 2, raio.getDirecao(0));
        a.set(1, 2, raio.getDirecao(1));
        a.set(2, 2, raio.getDirecao(2));
        
        Matrix t = new Matrix(3,3);
        t.set(0, 0, (vA.getX()) - (vB.getX()));
        t.set(1, 0, (vA.getY()) - (vB.getY()));
        t.set(2, 0, (vA.getZ()) - (vB.getZ()));
        t.set(0, 1, (vA.getX()) - (vC.getX()));
        t.set(1, 1, (vA.getY()) - (vC.getY()));
        t.set(2, 1, (vA.getZ()) - (vC.getZ()));
        t.set(0, 2, (vA.getX()) - (raio.getOrigem(0)));
        t.set(1, 2, (vA.getY()) - (raio.getOrigem(1)));
        t.set(2, 2, (vA.getZ()) - (raio.getOrigem(2)));
        
        double uf = u.det() / a.det();
        double vf = v.det() / a.det();
        double tf = t.det()/a.det();
        if (uf < 0) {
        return false;
        }
        if (vf < 0) {
        return false;
        }
        double soma = uf + vf;
        
        if (soma < 0) {
        return false;
        } else if (soma > 1) {
        return false;
        } else {
        return true;
        }*/
          Vetor x = vB.SubtraiVetor(vA);
        Vetor y = vC.SubtraiVetor(vA);
        Vetor n = x.produtoVetorial(y);
        Vetor d = new Vetor(raio.getDirecao(0),raio.getDirecao(1),raio.getDirecao(2));
        
        if(d.produtoInterno(n) != 0){
        Matrix matriz = new Matrix(3, 3);
        matriz.set(0, 0, (raio.getOrigem(0) - raio.getDirecao(0)));
        matriz.set(1, 0, (raio.getOrigem(1) - raio.getDirecao(1)));
        matriz.set(2, 0, (raio.getOrigem(2) - raio.getDirecao(2)));
        matriz.set(0, 1, (vB.getX()) - (vA.getX()));
        matriz.set(1, 1, (vB.getY()) - (vA.getY()));
        matriz.set(2, 1, (vB.getZ()) - (vA.getZ()));
        matriz.set(0, 2, (vC.getX()) - (vA.getX()));
        matriz.set(1, 2, (vC.getY()) - (vA.getY()));
        matriz.set(2, 2, (vC.getZ()) - (vA.getZ()));
        
        if((matriz.det() > 0.00001) || (matriz.det() < -0.00001)){
        Matrix coluna = new Matrix(3,1);
        coluna.set(0, 0, (raio.getOrigem(0) - (vA.getX())));
        coluna.set(1, 0, (raio.getOrigem(1) - (vA.getY())));
        coluna.set(2, 0, (raio.getOrigem(2) - (vA.getZ())));
        
        matriz = matriz.inverse();
        
        Matrix fim = matriz.times(coluna);
                if ((fim.get(1,0) >0) && (fim.get(1,0) < 1) && (fim.get(2,0)>0) && (fim.get(2,0)<1) && (fim.get(1,0) + fim.get(2,0) <= 1)){
                return true;}
            }
        }
        return false;
    }

    @Override
    public double aplicarTransformacao(double m) {
        return m;
    }

    @Override
    public double getReflexo() {
        return reflexo;
    }

    
}
