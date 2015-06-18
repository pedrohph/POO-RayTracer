package Raytracer;

import Jama.Matrix;

/**Classe para o uso da Camera do raytracer
 * 
 * @author Pedro H
 */

public class Camera {

    double altura;
    double largura;
    double w_alt;
    double w_larg;
    double distancia_focal;

    /**Construtor
     * 
     * @param a double - Altura
     * @param l double - Largura
     * @param wa double - Altura da janela
     * @param wl double - Largura da janela
     * @param df double - Distancia Focal
     */
    public Camera(double a, double l, double wa, double wl, double df) {
        this.altura = a;
        this.largura = l;
        this.w_alt = wa;
        this.w_larg = wl;
        this.distancia_focal = df;
    }

    /**Método getK
     * Calcula a matriz K necessária para os calculos do raio com o raytracer
     * @return retorna a matriz K
     */
    public Matrix getK() {
        double f = calculaF(altura, w_alt);

        Matrix k = new Matrix(3, 3);

        k.set(0, 0, f);
        k.set(0, 1, 0);
        k.set(0, 2, largura / 2);
        k.set(1, 0, 0);
        k.set(1, 1, -f);
        k.set(1, 2, altura / 2);
        k.set(2, 0, 0);
        k.set(2, 1, 0);
        k.set(2, 2, 1);

        return k;
    }

    /**Método getKInverso
     * 
     * @return KInverso
     */
    public Matrix getKInverso() {
        Matrix k = getK();
        return k.inverse();
    }

    /**Método getRaio
     * Utilizado para calcular a direção do Raio
     * @param pixel ponto 2D
     * @return Vetor de direção do raio
     */
    public Vetor getRaio(Pixel pixel) {
        Matrix ki = getKInverso();
        Matrix p = new Matrix(3, 1);
        p.set(0, 0, pixel.getX());
        p.set(1, 0, pixel.getY());
        p.set(2, 0, 1);

        Matrix direcao = ki.times(p);
        Vetor retorno = new Vetor(direcao.get(0, 0), direcao.get(1, 0), direcao.get(2, 0));

        return retorno;
    }
    /**Método getRaio
     * Utilizado para calcular a direção do Raio
     * @param v ponto 3D
     * @return Vetor de direção do raio
     */
    public Vetor getRaio(Vetor v) {
        Matrix ki = getKInverso();
        Matrix p = new Matrix(3, 1);
        p.set(0, 0, v.getX());
        p.set(1, 0, v.getY());
        p.set(2, 0, v.getZ());

        Matrix direcao = ki.times(p);
        Vetor retorno = new Vetor(direcao.get(0, 0), direcao.get(1, 0), direcao.get(2, 0));

        return retorno;
    }

    /**Método getX
     * 
     * @return altura real
     */
    public double getX() {
        return this.altura;
    }

    /**Método getY
     * 
     * @return largura real
     */
    public double getY() {
        return this.largura;
    }

/**Método calculaF
 * 
 * @param tamreal double - Tamanha real da imagem
 * @param tamjanela double - Tamanha da janela
 * @return double - distancia focal multiplicado por tamanho dividido por tamanho da janela
 */
    public double calculaF(double tamreal, double tamjanela) {
        double f = this.distancia_focal * (tamreal / tamjanela);
        return f;
    }

}
