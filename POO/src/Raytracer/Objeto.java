package Raytracer;
import Jama.*;
/**Classe Abstrata para Objetos
 * @author Pedro H
 * @version 1.0.0
 */

public abstract class Objeto {

    int[] cor_difusa = new int[3];
    int[] cor_especular = new int[3];
    double coef_de_brilho;
    double reflexo;

    /**Método getNormal abstrato utilizado para a cálculo da normal
     * 
     * @param d Vetor - Necessário para o cálculo referente a normal do objeto
     * @return Vetor - Referente a normal calculada
     */
    public abstract Vetor getNormal(Vetor d);

    /**Método intersecao abstrato utilizado para verificar se há interseção do raio com o objeto
     * 
     * @param raio Raio - Raio utilizado para a verificação da interseção.
     * @param t double - Desnecessário pode ser utilizado como 1
     * @return Boolean - true caso haja interseção false caso não haja interseção
     */
    public abstract boolean intersecao(Raio raio, double t);
/**Método aplicarTransformação - Método com matrizes para cada objeto, utilizado para quando o objeto
 * não esta na posição correta
 * 
 * @param m Matriz - Matriz de transformação
 * @return double - Referente a transformação
 */
    public abstract double aplicarTransformacao(double m);
/**Método calcularIntersecao - Método utilizado caso o método intersecao tenha retornado verdadeiro
 * 
 * @param raio Raio - Raio utilizado para calcular a interseção
 * @return double - Referente a interseção.
 */
    
    public abstract double calculaIntersecao(Raio raio);

    
    /**Método getCorDifusa - retorna a cor difusa do objeto de acordo com o parametro
     * 
     * @param i int - Referente a posição do vetor da cor difusa. 0 - X, 1 - Y, 2 - Z
     * @return int - Retorna a cor difusa do objeto
     */
    public abstract int getCorDifusa(int i);

    /**Método cor_especular - retorna a cor especular do objeto de acordo com o parametro
     * 
     * @param i int - Referente a posição do vetor da cor especular. 0 - X, 1 - Y, 2 - Z
     * @return int - Retorna a cor especular do objeto.
     */
    public abstract int cor_especular(int i);

    /**Método getBrilho - Retorna o brilho do objeto, utilizado para o calculo da cor especular
     * 
     * @return double retorna o Brilho do objeto
     */
    public abstract double getBrilho();
    /**Método getReflexo - retorna o reflexo do objeto.
     * @return double - Referente a taxa de reflexão do objeto; 
     */
    public abstract double getReflexo();

}
