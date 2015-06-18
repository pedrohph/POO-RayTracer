package Raytracer;
import Jama.Matrix;

/**
 * Classe para uso do raio do Raytracer,
 * @author Pedro H
 * @version 1.0.0
 */

public class Raio {

    public double[] origem = new double[3];
    public double[] direcao = new double[3];

//Construtor
    /**Método construtor, pegando a posição de origem do raio e a direção do mesmo
     * 
     * @param x double - Posição X da origem do raio
     * @param y double - Posição Y da origem do raio
     * @param z double - Posição Z da origem do raio
     * @param dx double - Direção X
     * @param dy double - Direção Y
     * @param dz double - Direção Z
     */
    public Raio(double x, double y, double z, double dx, double dy, double dz) {
        this.origem[0] = x;
        this.origem[1] = y;
        this.origem[2] = z;

        this.direcao[0] = dx;
        this.direcao[1] = dy;
        this.direcao[2] = dz;
    }
/**Método construtor, pegando a posição de origem do raio e a direção do mesmo
     * 
     * @param o Vetor - Vetor de origem do raio. Onde X,Y,Z do vetor equivalem ao X,Y,Z do raio
     * @param d Vetor - Vetor de direção do raio. Onde X,Y,Z do vetor equivalem ao X,Y,Z da direção do raio
     */
    
    public Raio(Vetor o, Vetor d) {
        this.origem[0] = o.getX();
        this.origem[1] = o.getY();
        this.origem[2] = o.getZ();

        this.direcao[0] = d.getX();
        this.direcao[1] = d.getY();
        this.direcao[2] = d.getZ();
    }

    /**Método construtor, pegando a posição de origem do raio e a direção do mesmo
     * 
     * @param x double - Posição X da origem do raio
     * @param y double - Posição Y da origem do raio
     * @param z double - Posição Z da origem do raio
     * @param v Vetor - Vetor de direção do raio. Onde X,Y,Z do vetor equivalem ao X,Y,Z da direção do raio
     */
    public Raio(double x, double y, double z, Vetor v) {
        this.origem[0] = x;
        this.origem[1] = y;
        this.origem[2] = z;

        this.direcao[0] = v.getX();
        this.direcao[1] = v.getY();
        this.direcao[2] = v.getZ();
    }
/**Método getOrigem, retorna a origem do raio de acordo com o parametro
 * 
 * @param i int - Referente a posição de origem. Onde 0 equivale a X, 1 equivale a Y, 2 equivale a Z
 * @return array de double - retornando uma das cordenadas de origem do raio.
 */
    
    public double getOrigem(int i) {
        return origem[i];
    }

    /**Método getDirecao, retorna a direção do raio de acordo com o parametro
 * 
 * @param i int - Referente a direção do raio. Onde 0 equivale a X, 1 equivale a Y, 2 equivale a Z
 * @return array de double - retornando uma das cordenadas da direção do raio.
 */
    public double getDirecao(int i) {
        return direcao[i];
    }

    /**Método normalizarRaio, calcula a normalização do raio de acordo com sua origem.
     * 
     * @param u Vetor - Recebe o vetor para a normalização do Raio
     * @return Vetor - Raio normalizado
     */
    public Vetor normalizarRaio(Vetor u) {
        double quaseNorma = Math.pow(u.getX(), 2) + Math.pow(u.getY(), 2) + Math.pow(u.getZ(), 2);
        float norma = (float) Math.sqrt(quaseNorma);
        // devolve vetor normalizado
        u.setVetor(u.getX() / norma, u.getY() / norma, u.getZ() / norma);
        return u;
    }

}
