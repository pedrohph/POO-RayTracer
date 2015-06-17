package Raytracer;

import Jama.Matrix;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

public class Raytracer extends JFrame {
//int pox;
//int poy;
//Color c;

    public Raytracer() {
        super("Raytracer!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        //Janela para pintar imagem
        Raytracer janela = new Raytracer();
        janela.setSize(1024, 768);
        janela.setVisible(true);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //Pega cor rgb
        int[] cor = new int[3];
        Vetor cores = new Vetor(0, 0, 0);

        //Pega objetos da lista (Pq ta dando inutilizado?)
        ArrayList<Objeto> ob = new ArrayList<>();
        //Pega todas as luzes (trabalharei só com uma por hora)
        ArrayList<Luz> luz = new ArrayList<>();
        
        //Calculo do tmenor
        Pixel inter;
        double tmenor;
        int indob;
        
        //Criação da cena
        Cenas ce = new Cenas();
        
        Scanner ok = new Scanner(System.in);
        
        int op=1;
        while(op!=0){
        Scanner ler = new Scanner(System.in);
        ler.reset();
        System.out.println("1 - Adicionar Circulo");
        System.out.println("2 - Adicionar Luz");
        System.out.println("3 - Ler OBJ");
        System.out.println("0 - RayTracer");
        op = ler.nextInt();
        
        switch(op){
            case 1:
                ok = new Scanner(System.in);
                ok.reset();
                System.out.println("Digite os pontos X,Y,Z do centro da esfera(separado por virgula)");
                String cord = ok.nextLine();
                String[] separa = cord.split(",");
                int x = Integer.parseInt(separa[0]);
                int y = Integer.parseInt(separa[1]);
                int z = Integer.parseInt(separa[2]);
                ok.reset();
                System.out.println("Digite o tamanho do Raio da sua esfera");
                int r = ok.nextInt();
                ok.reset();
                System.out.println("Digite a cor RED da sua esfera");
                int cr = ok.nextInt();
                ok.reset();
                System.out.println("Digite a cor GREEN da sua esfera");
                int cg = ok.nextInt();
                ok.reset();
                System.out.println("Digite a cor BLUE da sua esfera");
                int cb = ok.nextInt();
                ok.reset();
                System.out.println("Sua esfera terá reflexão? 0-Nao  1-Sim");
                int refle = ok.nextInt();
                ok.reset();
                Esfera e = new Esfera(x,y,z,r,cr,cg,cb,255,255,255,refle);
                ce.addEsferaCena(e);
                break;
            case 2:
                ok = new Scanner(System.in);
                 ok.reset();
                System.out.println("Digite os pontos X,Y,Z da luz(separado por virgula)");
                String luzcod = ok.nextLine();
                String[] sp = luzcod.split(",");
                double xl = Double.valueOf(sp[0]);
                double yl = Double.valueOf(sp[1]);
                double zl = Double.valueOf(sp[2]);
                ok.reset();
                System.out.println("Digite a intensidade R,G,B da luz (separado por virgula)");
                ok.reset();
                String luzint = ok.nextLine();
                String[] sep = luzcod.split(",");
                double irl = Double.valueOf(sep[0]);
                double igl = Double.valueOf(sep[1]);
                double ibl = Double.valueOf(sep[2]);
                ok.reset();
                Luz nlc = new Luz(xl,yl,zl,irl,igl,ibl);
                ce.addLuz(nlc);
                break;
                case 3:
                    ce.lerObj("C:\\Users\\Pedro H\\Desktop\\Faculdade\\CG\\150 - Mewtwo\\OK.obj");
                    break;
                case 5:
                    break;
        }
        
        }
        
        
        //Chama cena, raio, camera, pixel;
        
        ce.CriarCena();
        Raio r;
        Camera c = new Camera(1024, 768, 4, 3, 1);
        Pixel px = new Pixel();

        //Distancia do raio
        Vetor d;
        //Pega todos os objetos da cena
        ob = ce.getObjetos();
        //Pega todas as luzes da cena
        luz = ce.getLuz();

        //Começa o raytracer J = Y e I = X;
        System.out.println(ob.size());
        for (int j = 0; j < 768; j++) {
            for (int i = 0; i < 1024; i++) {
                //Altera pixel para o uso de D (tambem para pegar normal, gerar as cores e etc)
                px.setPixel(i, j);
                d = c.getRaio(px);
                r = new Raio(0, 0, 0, d);

                //Calcula a intersecao de todos os objetos e pega a menor
                cores = raytracer(r, ob, luz, ce, 0);
                cor[0] = (int) cores.getX();
                cor[1] = (int) cores.getY();
                cor[2] = (int) cores.getZ();

              //Pinta pela a cor já determinada
                Color cornova = new Color(cor[0], cor[1], cor[2]);
                g.setColor(cornova);
                //Pinta o pixel XY (i,j);
                g.drawRect(i, j, 1, 1);
                //Manda tmenor para 9999 e recomeça tudo

            }
        }

    }

    public Vetor raytracer(Raio r, ArrayList<Objeto> ob, ArrayList<Luz> luz, Cenas ce, int ref) {
        ArrayList<Double> inter = new ArrayList<>();
        double tmenor = 9999;
        int posicaoobjeto;
        int indob;
        //Vetor para a normal
        Vetor normal;

        //Vetores para as cores
        Vetor corReal;
        Vetor corDifusa;
        Vetor corEspecular;
        Vetor corAmbiente;

        //Cria d
        Vetor d = new Vetor(r.getDirecao(0), r.getDirecao(1), r.getDirecao(2));

        //Vetor de Cor
        Vetor cor = new Vetor(0, 0, 0);

        //Cria o retorno onde X é Tmenor e Y é o indice do objeto 
        Pixel retorno = new Pixel(0, 0);

        for (int x = 0; x < ob.size(); x++) {
            if (ob.get(x).intersecao(r, 1)) {
                inter.add(ob.get(x).calculaIntersecao(r));

            } //Caso não haja interseção coloca inter[x] como -1
            else {
                inter.add((double) -1);
            }
        }

        //Checa T menor 
        for (int x = 0; x < ob.size(); x++) {
            //aqui deve-se verificar e definir o T menor
            if (inter.get(x) > 0.01) {

                if (tmenor > inter.get(x)) {
                    tmenor = inter.get(x);
                    posicaoobjeto = x;
                    retorno.setPixel(tmenor, posicaoobjeto);
                }
            }
        }
        tmenor = retorno.getX();
        indob = (int) retorno.getY();

        //aqui deve-se verificar e definir o T menor
        if (tmenor > 0.01) {

            corDifusa = new Vetor(0, 0, 0);
            corEspecular = new Vetor(0, 0, 0);

            Vetor bateup = d.multiplicarVetor(tmenor);
            normal = ob.get(indob).getNormal(bateup);

            int stop = 0;
            for (int indluz = 0; indluz < luz.size(); indluz++) {
                //Raio objeto -> luz
                Raio rol = new Raio(bateup, luz.get(indluz).calcularDirecaoDaLuz(bateup));
                for (int z = 0; z < ob.size(); z++) {
                    if (ob.get(z).intersecao(rol, 1)) {
                        if (ob.get(z).calculaIntersecao(rol) > 0.01 && ob.get(z).calculaIntersecao(rol) <= 1) {
                            stop = 1;
                            break;
                        }
                    }
                }
                if (stop == 0) {
                    Vetor direcaodaluz = luz.get(indluz).calcularDirecaoDaLuz(bateup);
                    float n = direcaodaluz.normalizarVetor();
                    direcaodaluz = direcaodaluz.dividirVetor(n);
                    corDifusa = corDifusa.adicaoVetor(luz.get(indluz).calcularDifusa(normal, direcaodaluz, ob.get(indob)));
                    corEspecular = corEspecular.adicaoVetor(luz.get(indluz).calcularEspecular(d, direcaodaluz, ob.get(indob), r, normal));

                } else {
                    stop = 0;
                }
            }
            if(ob.get(indob).getReflexo()>0 && ref <=3){
                //Aqui devo calcular a reflexão perfeita;
               Vetor dn = d.SubtraiVetor(normal.multiplicarVetor((normal.produtoInterno(d) * 2)));
               Raio rn = new Raio (bateup,dn);
               ref++;
               cor = raytracer(rn, ob, luz, ce, ref);
            }
            
            

            corAmbiente = ce.getCorAmbiente();
            corReal = corDifusa.adicaoVetor(corEspecular);
            corReal = corReal.adicaoVetor(corAmbiente);

            //Salva as cores do objeto frente 
            cor.setX(cor.getX() + corReal.getX());
            cor.setY(cor.getY() + corReal.getY());
            cor.setZ(cor.getZ() + corReal.getZ());

            if (cor.getX() > 255) {
                cor.setX(255);
            } else if (cor.getX() < 0) {
                cor.setX(0);
            }
            if (cor.getY() > 255) {
                cor.setY(255);
            } else if (cor.getY() < 0) {
                cor.setY(0);
            }
            if (cor.getZ() > 255) {
                cor.setZ(255);
            } else if (cor.getZ() < 0) {
                cor.setZ(0);
            }
            
        } else {
            corDifusa = new Vetor(0, 0, 0);
            corEspecular = new Vetor(0, 0, 0);
            tmenor = 9999;
        }

        //Se T menor não tiver sido alterado coloca as cores da cena;
        if (tmenor == 9999) {
            Vetor cordacena = ce.getCorAmbiente();
            cor.setX(cordacena.getX());
            cor.setY(cordacena.getY());
            cor.setZ(cordacena.getZ());

        }

        return cor;
    }
}
