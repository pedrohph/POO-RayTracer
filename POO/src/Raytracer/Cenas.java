package Raytracer;

import Jama.*;
import java.awt.Color;
import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Cenas {

    ArrayList<Objeto> ob = new ArrayList<>();
    ArrayList<Objeto> listaDeObj = new ArrayList<Objeto>();
    Vetor cor;
    double intensidade;
    ArrayList<Luz> luz = new ArrayList<>();
    ArrayList<Vetor> vet = new ArrayList<>();

    public void CriarCena() {
    
        /* Esfera e = new Esfera(1,2,0.4,1, 255, 0, 0, 0,0,0, 0);
        this.ob.add(e);
        e = new Esfera(10,-12,50,10,255,255,0 , 0,0,0, 0);
        this.ob.add(e);
        
        e = new Esfera(10,50,50,10,255,255,0, 0,0,0, 0);
        this.ob.add(e);
        
        
        e = new Esfera(-40, 40, 150, 20, 255,255,255, 0,0,0, 0);
        this.ob.add(e);
        e = new Esfera(-20, 20, 75, 5, 0,0,0, 0,0,0, 0);
        this.ob.add(e);
        
        e = new Esfera(-40, 80, 150, 20, 255,255,255, 0,0,0, 0);
        this.ob.add(e);
        e = new Esfera(-20, 40, 75, 5, 0,0,0, 0,0,0, 0);
        this.ob.add(e);
        
        e = new Esfera(10,30,75,15, 255, 255,0, 0,0,0, 0);
        this.ob.add(e);
        
        e = new Esfera(30,60,150,30, 255, 0, 0, 0,0,0, 0);
        this.ob.add(e);
        
        e = new Esfera(10,60,200,100, 255, 255, 0, 0,0,0, 0);
        this.ob.add(e);
        
        Vetor a = new Vetor(10,10,10);
        Vetor b = new Vetor(20,20,10);
        Vetor c = new Vetor(30,10,10);
        
        Triangulo t = new Triangulo(a,b,c, 255,0,200, 255, 255, 255);
        this.ob.add(t);
        
        a = new Vetor(-30,-40,100);
        b = new Vetor(-40,-40,90);
        c = new Vetor(-40,-40,150);
        t = new Triangulo(a,b,c, 255,0,200, 0, 255, 255);
        this.ob.add(t);
        
        a = new Vetor(33,-30,40);
        b = new Vetor(55,-20,40);
        c = new Vetor(25,20,40);
        t = new Triangulo(a,b,c, 0,255,255, 10, 10, 55);
        this.ob.add(t);
        
        a = new Vetor(40,15,40);
        b = new Vetor(55,-10,20);
        c = new Vetor(70,20,32);
        t = new Triangulo(a,b,c, 0,255,255, 250, 10, 55);
        this.ob.add(t);
        
        
        a = new Vetor(50,50,50);
        b = new Vetor(50,-50,50);
        c = new Vetor(5,5,50);
        t = new Triangulo(a,b,c, 0,255,255, 250, 50, 255);
        this.ob.add(t);
        
        
        
        Luz l = new Luz(5,5,5,0.5, 0.1, 0.3);
        this.luz.add(l);
        l = new Luz(0,0,50,0.2,0.3, 0.5);
        this.luz.add(l);
        
        cor = new Vetor(0,0,150);
        intensidade = 0.5;*/
        
        //Corpo
        /* Esfera e = new Esfera(0, 30, 100, 30, 255, 255, 255, 255, 255, 255, 0);
        this.ob.add(e);
        e = new Esfera(0, 0, 180, 70, 255, 255, 255, 255, 255, 255, 0);
        this.ob.add(e);
        
        //Chão
        e = new Esfera(20, 20, 1000, 800, 0, 255, 255, 255, 255, 255, 0);
        this.ob.add(e);
        
        //Olhos
        e = new Esfera(5, 25, 70, 3, 0, 0, 0, 0,0,0, 0);
        this.ob.add(e);
        e = new Esfera(-5, 25, 70, 3, 0, 0, 0, 0,0,0, 0);
        this.ob.add(e);
        
        //Boca
        e = new Esfera(0, 15, 82, 8, 255, 0, 0, 255,0,0, 0);
        this.ob.add(e);
        
        Vetor a = new Vetor(150, 10, 150);
        Vetor b = new Vetor(-10, 10, 150);
        Vetor c = new Vetor(-10, -100, 150);
        
        Triangulo t = new Triangulo(a, b, c, 255, 255, 0, 0, 0, 0);
        this.ob.add(t);
        
        Luz l = new Luz(5,5,5,1,1,1);
        this.luz.add(l);
        l = new Luz(0,150,100,1,1,1);
        this.luz.add(l);
        
        cor = new Vetor(0, 0, 0);
        intensidade = 1;*/
        
        Esfera e = new Esfera(15,0,30,10,255,0,0,255,255,255,1);
        this.ob.add(e);
        
        e = new Esfera(25,0,10,10,0,255,0,255,255,255,1);
        this.ob.add(e);
        
         e = new Esfera(1,0.8,2,0.2,0,0,255,255,255,255,1);
        this.ob.add(e);

        Vetor a = new Vetor(0, 500, 500);
        Vetor b = new Vetor(2500, -1000, 500);
        Vetor c = new Vetor(-1500, -1000, 500);
        
        Triangulo t = new Triangulo(a, b, c, 255, 255, 0, 0, 0, 0);
        this.ob.add(t);
        
        
         Luz l = new Luz(0,0,40,1,1,1);
        this.luz.add(l);
        l = new Luz(0,0,0,1,1,1);
        this.luz.add(l);

        cor = new Vetor(0, 0, 0);
        intensidade = 1;
      
    }

    public void addEsferaCena(Objeto objeto) {
        listaDeObj.add(objeto);
    }

    public ArrayList getLuz() {
        return luz;
    }

    public ArrayList getObjetos() {
        return ob;
    }

    public Vetor getCor() {
        return this.cor;
    }

    public Vetor getCorAmbiente() {
        Vetor corAmbiente;

        corAmbiente = cor.multiplicarVetor(intensidade);

        return corAmbiente;
    }

    public void lerObj(String arq){
       try{
       FileReader f = new FileReader(arq);
       BufferedReader lerArq = new BufferedReader(f);
       String linha = lerArq.readLine();
       while(linha!= null){
          System.out.println(linha);  
       
        if(linha.contains("v ")){
        String[] dividir = linha.split(" ");
        double e1 = Double.parseDouble(dividir[1]);
        double e2 = Double.parseDouble(dividir[2]);
        double e3 = Double.parseDouble(dividir[3]);
        e3 += 50;
        Vetor v = new Vetor(e1,e2,e3);
        vet.add(v);        
       }
       
       if(linha.contains("f ")){
           String[] novadivisao = linha.split(" ");
           int v1 = (int)Double.parseDouble(novadivisao[1].substring(0, novadivisao[1].indexOf("/")));
           int v2 = (int)Double.parseDouble(novadivisao[2].substring(0, novadivisao[2].indexOf("/")));
           int v3 = (int)Double.parseDouble(novadivisao[3].substring(0, novadivisao[3].indexOf("/")));
           Triangulo t = new Triangulo(vet.get(v1-1),vet.get(v2-1),vet.get(v3-1),255,0,0,0,0,0);
             System.out.println(v1 + " " + v3+ " " + v2);
           ob.add(t);                      
       }
        linha = lerArq.readLine();
       }   
        }catch(Exception e){e.printStackTrace();}
            
         Luz l = new Luz(80,0,40,1,1,1);
        this.luz.add(l);
        l = new Luz(0,0,0,1,1,1);
        this.luz.add(l);
        l = new Luz(39,50,12,1,1,1);
        this.luz.add(l);

        this.cor = new Vetor(0, 0, 255);
        intensidade = 1;
    }
    
}
