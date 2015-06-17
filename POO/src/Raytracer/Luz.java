package Raytracer;

import Jama.*;
import static java.lang.Math.pow;

public class Luz {

    Vetor intensidade;
    Vetor posicao;
    Vetor cor;
//cor da luz adicionar depois 

    public Luz(double px, double py, double pz, double xi, double yi, double zi) {
        intensidade = new Vetor(xi, yi, zi);
        posicao = new Vetor(px, py, pz);
        cor = new Vetor(1, 1, 1);
    }

    public Vetor getPosicao() {
        return this.posicao;
    }

    public Vetor getIntensidade() {
        return intensidade;
    }

    public Vetor calcularDirecaoDaLuz(Vetor d) {
        //Tudo isso agora e um vetor deve ser ajustado
        Vetor l = posicao.SubtraiVetor(d);
    //float nl = l.normalizarVetor();

   // l.setX(l.getX()/nl);
        // l.setY(l.getY()/nl);
        // l.setZ(l.getZ()/nl);
        return l;
    }

    public Vetor calcularDifusa(Vetor normal, Vetor l, Objeto ob) {

        Vetor corob = new Vetor(ob.getCorDifusa(0), ob.getCorDifusa(1), ob.getCorDifusa(2));

    //normaliza intensidade
        //double ni = intensidade.normalizarVetor();
        double max = normal.produtoInterno(l);
        if (max < 0) {
            max = 0;
        }

        Vetor difusa = corob.multiplicarVetor(intensidade.multiplicarVetor(max));

        return difusa;
    }

    public Vetor calcularEspecular(Vetor d, Vetor l, Objeto ob, Raio r, Vetor normal) {

        //pega as cores do objeto e a origem do raio;
        Vetor corob = new Vetor(ob.cor_especular(0), ob.cor_especular(1), ob.cor_especular(2));
        Vetor raioOrigem = new Vetor(r.getOrigem(0), r.getOrigem(1), r.getOrigem(2));

        Vetor dn = d.adicaoVetor(l);
   // double nd = l.normalizarVetor(raioOrigem.produtoInterno(d));

   // l.setX(dn.getX()/nd);
        // l.setY(dn.getY()/nd);
        // l.setZ(dn.getZ()/nd);
        double nd = dn.normalizarVetor();
        Vetor nh = dn.dividirVetor(nd);
        double max = normal.produtoInterno(nh);

        if (max < 0) {
            max = 0;
        }

        double max1 = Math.pow(max, ob.getBrilho());

        Vetor especular = corob.multiplicarVetor(intensidade.multiplicarVetor(max1));
        return especular;
    }

}
