package Raytracer;
/**Classe para o uso de Pontos em 2D, utilizado para calculo em raios
 * 
 * @author Pedro H
 * @version 1.0.0
 */

public class Pixel {

    public double x, y;
/**Construtor caso não haja nenhum parametro X e Y ficam igual a 0
 */
    public Pixel() {
        this.x = 0.0;
        this.y = 0.0;
    }
/**Construtor
 * 
 * @param x double - equivalente a coordenada X do pixel
 * @param y double - equivalente a coordenada Y do pixel
 */
    public Pixel(double x, double y) {
        this.x = x;
        this.y = y;
    }
/**Método getX
 * 
 * @return double - Posição X do pixel 
 */
    public double getX() {
        return this.x;
    }
/**Método getY
 * 
 * @return double - Posição Y do pixel
 */
    public double getY() {
        return this.y;
    }
/**Método setPixel utilizado para alterar o pixel por completo
 * 
 * @param nX double - posição X do pixel
 * @param nY double - posição Y do pixel
 */
    
    public void setPixel(double nX, double nY) {
        this.x = nX;
        this.y = nY;
    }

}
