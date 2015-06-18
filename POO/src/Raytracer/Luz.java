package Raytracer;

import Jama.*;
import static java.lang.Math.pow;

/**Classe para a luz da cena do raytracer
 * 
 * @author Pedro H
 * @version 1.0.0
 */

public class Luz {

    Vetor intensidade;
    Vetor posicao;
    Vetor cor;
//cor da luz adicionar depois 
/**Construtor
 * 
 * @param px - Posição X da luz
 * @param py - Posição Y da luz
 * @param pz - Posição Z da luz
 * @param xi - Intensidade X da luz
 * @param yi - Intesidade Y da luz
 * @param zi - Intesidade Z da luz
 */
    public Luz(double px, double py, double pz, double xi, double yi, double zi) {
        intensidade = new Vetor(xi, yi, zi);
        posicao = new Vetor(px, py, pz);
        cor = new Vetor(1, 1, 1);
    }

/**Método getPosicao
 * 
 * @return Vetor - posição da luz
 */    
    public Vetor getPosicao() {
        return this.posicao;
    }
/**Método getIntensidade
 * 
 * @return  Vetor - Intensidade da luz
 */
    public Vetor getIntensidade() {
        return intensidade;
    }

    /**Método calcularDirecaoDaLuz
     * 
     * @param d Vetor - Equivale a posição onde o raio bateu
     * @return Vetor - Equivalente a Direção da luz
     */
    public Vetor calcularDirecaoDaLuz(Vetor d) {
        //Tudo isso agora e um vetor deve ser ajustado
        Vetor l = posicao.SubtraiVetor(d);
    //float nl = l.normalizarVetor();

   // l.setX(l.getX()/nl);
        // l.setY(l.getY()/nl);
        // l.setZ(l.getZ()/nl);
        return l;
    }
/**Método calcularDifusa
 * 
 * @param normal  Vetor - Normal do raio utilizado
 * @param l Vetor - Direção da Luz (calculado no método calcularDirecaoDaLuz
 * @param ob Objeto - Objeto onde a luz esta batendo
 * @return Vetor - Equivalente a cor Difusa do objeto, onde X,Y,Z do vetor equivalem ao R,G,B da cor
 */
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

    /**Método calcularEspecular - Calcula a cor Especular do objeto
     * 
     * @param d Vetor - Equivalente a direção do raio
     * @param l Vetor - Equivalente a direção da luz (calculado no método calcularDirecaoDaLuz)
     * @param ob Objeto - Objeto onde a luz está batendo
     * @param r Raio - Raio que bate no objeto
     * @param normal - Normal do raio
     * @return Vetor - Equivalente a cor Especular do objeto, onde X,Y,Z do vetor equivalem ao R,G,B da cor
     */
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
