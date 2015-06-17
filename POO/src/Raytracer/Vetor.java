package Raytracer;
/** Clase para cálculos de pontos com 3 dimensões, contendo métodos para facilitar o
 * uso de expressões Matematicas.
 * @author Pedro H
 * @version 1.0.0
 */

public class Vetor {

    public double x;
    public double y;
    public double z;

    /**Método Construtor, pode ser criado um vetor vazio atribuindo 0 aos 3 pontos (x,y,z)*/
    
    public Vetor() {
        x = 0.0;
        y = 0.0;
        z = 0.0;
    }

    /**Método Construtor, pode ser criado um vetor com double atribuindo seus valores aos 3 pontos (x,y,z)
     *@param vx double - Valor da posicao x;
     * @param vy double - Valor da posicao y;
     * @param vz double - Valor da posicao z;
     * 
     */
    public Vetor(double vx, double vy, double vz) {
        x = vx;
        y = vy;
        z = vz;
    }

    /**Método Construtor, pode ser criado um Vetor apartir de um outro Vetor atribuindo seus valores ao 3 pontos (x,y,z)
     * 
     * @param vetor Vetor - Os pontos x y z do vetor serão atribuidos aos novos em sua ordem;
     */
    public Vetor(Vetor vetor) {
        x = vetor.x;
        y = vetor.y;
        z = vetor.z;
    }

    /**Método setVetor, utilizado para alterar todo o vetor
     * 
     * @param vx double - Utilizado para alterar o valor de X
     * @param vy double - Utilizado para alterar o valor de Y
     * @param vz double - Utilizado para alterar o valor de Z
     */
    public void setVetor(double vx, double vy, double vz) {
        this.x = vx;
        this.y = vy;
        this.z = vz;
    }

    /**Método getX, utilizado para receber informação do valor do ponto X
     * 
     * @return double - Valor do ponto X desse vetor 
     */
    public double getX() {
        return x;
    }

    /**Método getY, utilizado para receber informação do valor do ponto Y
     * 
     * @return double - Valor do ponto Y desse vetor 
     */
    public double getY() {
        return y;
    }

    /**Método getZ, utilizado para receber informação do valor do ponto Z
     * 
     * @return double - Valor do ponto Z desse vetor 
     */
    public double getZ() {
        return z;
    }

    /**Método setX, utilizado para modificar o valor do ponto X
     * 
     * @param d double - Valor que o ponto X, desse vetor, deve assumir
     */
    public void setX(double d) {
        this.x = d;
    }

     /**Método setY, utilizado para modificar o valor do ponto Y
     * 
     * @param d double - Valor que o ponto Y, desse vetor, deve assumir
     */
    public void setY(double d) {
        this.y = d;
    }

     /**Método setZ, utilizado para modificar o valor do ponto Z
     * 
     * @param d double - Valor que o ponto Z, desse vetor, deve assumir
     */
    public void setZ(double d) {
        this.z = d;
    }

    /**Método normalizarVetor, utilizado para calcular a normal de um vetor
     * Cada um dos pontos (x,y,z) é multiplicado ao quadrado. Com a soma dos 3 valores calcula-se a raiz quadrada do total
     * e retorna esse valor;
     * @return float - Resultado da normal de um vetor 
     */
    public float normalizarVetor() {
        double quaseNorma = Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2);
        float norma = (float) Math.sqrt(quaseNorma);
            // devolve vetor normalizado
        //u.set(u.getX()/norma, u.getY()/norma, u.getZ()/norma);
        return norma;

    }
    /**Método normalizaMenosVetor, utilizado para calcular a diferença de valores da norma de dois vetores
     * 
     * @param x Vetor - Vetor que será calculado a norma e subtraido da normal do primeiro vetor
     * @return float - resulltado da subtração das duas normas
     */
    public float normalizarMenosVetor(Vetor x) {
        float resultado = this.normalizarVetor() - x.normalizarVetor();

        return resultado;
    }
    /**Método multiplicarVetor, utilizado para multiplicar dois vetores.
     * Multiplicando cada ponto do primeiro vetor com cada ponto do segundo vetor
     * @param b Vetor - Segundo vetor, usado para fazer a multiplicação.
     * @return Vetor - retorna um vetor com o valor da multiplicação
     */
    public Vetor multiplicarVetor(Vetor b) {
        Vetor c = new Vetor(this.x * b.getX(), this.y * b.getY(), this.z * b.getZ());
        return c;
    }
    /**Método multiplicaVetor, utilizado para multiplicar um vetor com um valor escalar.
     * Multiplica-se cada ponto do vetor pelo valor escalar
     * @param b double - Valor para multiplicar o vetor
     * @return Vetor - retorna um vetor com o valor da multiplicação
     */
    public Vetor multiplicarVetor(double b) {
        Vetor c = new Vetor(this.x * b, this.y * b, this.z * b);
        return c;
    }

    /**Método adicaoVetor, utilizado para somar dois vetores
     * Soma-se cada ponto do primeiro vetor com cada ponto do segundo vetor
     * @param b Vetor - Segundo vetor, usado para fazer a soma
     * @return Vetor - retorna um vetor com a soma dos dois vetores
     */
    public Vetor adicaoVetor(Vetor b) {
        Vetor c = new Vetor(this.x + b.getX(), this.y + b.getY(), this.z + b.getZ());
        return c;
    }
    /**Método SubtraiVetor, utilizado para diminuir dois vetores
     * Subtrai-se cada ponto do primeiro vetor com cada ponto do segundo vetor
     * @param u Vetor - Segundo vetor, usado para fazer a subtracao
     * @return Vetor - retorna um vetor com a subtração dos dois vetores
     */
    public Vetor SubtraiVetor(Vetor u) {
        Vetor w = new Vetor(this.x - u.getX(), this.y - u.getY(), this.z - u.getZ());

        return w;
    }
     /**Método dividirVetor, utilizado para dividir dois vetores
     * Divide-se cada ponto do primeiro vetor com cada ponto do segundo vetor
     * Caso algum ponto do segundo vetor seja igual a 0 (zero), esse será modificado para 1(um)
     * @param b Vetor - Segundo vetor, usado para fazer a divisão
     * @return Vetor - retorna um vetor com a divisão dos dois vetores
     */
    public Vetor dividirVetor(Vetor b) {
        if (b.getX() == 0) {
            b.setX(1);
        }
        if (b.getY() == 0) {
            b.setY(1);
        }
        if (b.getZ() == 0) {
            b.setZ(1);
        }
        Vetor c = new Vetor(this.getX() / b.getX(), this.getY() / b.getY(), this.getZ() / b.getZ());
        return c;
    }
 /**Método dividirVetor, utilizado para dividir um vetor com um valor escalar
     * Divide-se cada ponto do primeiro vetor com o segundo valor
     * Caso algum o segundo vetor seja igual a 0 (zero), esse será modificado para 1(um)
     * @param b double - Valor usado para fazer a divisão
     * @return Vetor - retorna um vetor com a divisão dos dois valores
     */
    public Vetor dividirVetor(double b) {
        if (b == 0) {
            b = 1;
        }

        Vetor c = new Vetor(this.getX() / b, this.getY() / b, this.getZ() / b);
        return c;
    }

    
/**Método produtoInterno, utilizado para calcular o produto interno entre dois vetores.
 * Soma-se a multiplicação de cada um dos pontos do primeiro vetor pelo segundo vetor
 * @param v2 Vetor - Segundo vetor utilizado para calcular o produto interno
 * @return double - Resultado do produto interno entre os vetores
 */
    public double produtoInterno(Vetor v2) {
        double d = ((this.x * v2.getX()) + (this.y * v2.getY()) + (this.z * v2.getZ()));
        return d;
    }

    
/**Método produtoInterno, utilizado para calcular o produto interno de um único vetor.
 * Soma-se a multiplicação de cada um dos pontos do vetor por cada um dos pontos desse mesmo vetor
 * @return double - Resultado do produto interno desse vetor
 */
    public double produtoInterno() {
        double d = ((this.x * this.x) + (this.y * this.y) + (this.z * this.z));
        return d;
    }

/**Método produtoVetorial, utilizado para calcular o produto vetórial entre dois vetores.
 * @param b Vetor - Segundo vetor utilizado para fazer o calculo
 * @return Vetor - Resultado do Produto Vetorial entre dois vetores.
 */
    public Vetor produtoVetorial(Vetor b){
        Vetor produto = new Vetor();
        produto.setX((this.y*b.getZ()) - (b.getY()*this.z)); 
        produto.setY((b.getX()*this.z) - (this.x * b.getZ()));
        produto.setZ((this.x*b.getY()) - (b.getX() * this.y));

        return produto;
        
    }
    
}
