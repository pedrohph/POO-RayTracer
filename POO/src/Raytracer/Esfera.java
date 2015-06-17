package Raytracer;

public class Esfera extends Objeto {

    double[] centro = new double[3];
    double raio;
    Equacao e;

    public Esfera(double x, double y, double z, double r, int cr, int cg, int cb, int er, int eg, int eb, double ref) {
        this.centro[0] = x;
        this.centro[1] = y;
        this.centro[2] = z;
        this.raio = r;

        this.cor_difusa[0] = cr;
        this.cor_difusa[1] = cg;
        this.cor_difusa[2] = cb;

        this.cor_especular[0] = er;
        this.cor_especular[1] = eg;
        this.cor_especular[2] = eb;

        coef_de_brilho = 1;
        reflexo = ref;

    }

    @Override
    public Vetor getNormal(Vetor d) {
        Vetor ccentro = new Vetor(this.centro[0], this.centro[1], this.centro[2]);
        Vetor normal = d.SubtraiVetor(ccentro);
        double n = normal.normalizarVetor();
        normal = normal.dividirVetor(n);
        return normal;
    }

    @Override
    public double calculaIntersecao(Raio rraio) {
        double t1, t2;

        double xc = rraio.getOrigem(0);
        double yc = rraio.getOrigem(1);
        double zc = rraio.getOrigem(2);
        double xd = rraio.getDirecao(0);
        double yd = rraio.getDirecao(1);
        double zd = rraio.getDirecao(2);

        double a = (xd * xd) + (yd * yd) + (zd * zd);
        double b = 2 * (xd * (xc - this.centro[0]) + yd * (yc - this.centro[1]) + zd * (zc - this.centro[2]));
        double c = (xc - this.centro[0]) * (xc - this.centro[0]) + (yc - this.centro[1]) * (yc - this.centro[1]) + (zc - this.centro[2]) * (zc - this.centro[2]) - (this.raio * this.raio);

        e = new Equacao(a, b, c);
        t1 = e.getT1();
        t2 = e.getT2();
        
        if (t1 <= t2) {
            return t1;
        } else {
            return t2;
        }

    }

    @Override
    public boolean intersecao(Raio rraio, double t) {

        double xc = rraio.getOrigem(0);
        double yc = rraio.getOrigem(1);
        double zc = rraio.getOrigem(2);
        double xd = rraio.getDirecao(0);
        double yd = rraio.getDirecao(1);
        double zd = rraio.getDirecao(2);

        double a = (xd * xd) + (yd * yd) + (zd * zd);
        double b = 2 * (xd * (xc - this.centro[0]) + yd * (yc - this.centro[1]) + zd * (zc - this.centro[2]));
        double c = (xc - this.centro[0]) * (xc - this.centro[0]) + (yc - this.centro[1]) * (yc - this.centro[1]) + (zc - this.centro[2]) * (zc - this.centro[2]) - (this.raio * this.raio);

        e = new Equacao(a, b, c);

        return e.getDelta();
    }

    public void setCor(int r, int g, int b) {
        this.cor_difusa[0] = r;
        this.cor_difusa[1] = g;
        this.cor_difusa[2] = b;

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
    public int getCorDifusa(int i) {
        return cor_difusa[i];
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
