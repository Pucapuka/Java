
package com.mycompany.animacao;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Animacao extends JFrame
                      implements Runnable{
    Thread t;
    boolean exe = false;
    int i = 0;
    int j = 100;
    int direcao = 5;
    int k,l,m = 0;
    
    public Animacao(){
        t = new Thread(this);
        setSize(800,500);
        setVisible(true);
        showNotify();
    }
    
    public void showNotify(){ //método para iniciar a animação
        t.start();
        exe = true;
    }
    
        public void hideNotify(){ //método para parar a animação
        exe = false;
        t = null;
    }
    
    public void runn(){ //esse método faz o desenho do paint subir e descer
        while(true){
            j+=direcao;
            
            if(j<=0 || j>=getHeight()-100){
                direcao*=-1;
            }
        try{
           Thread.sleep(50);
        }catch(Exception e){}
        repaint();
        }
    }
    
    public void rainDrops(){ //esse método faz o desenho do paint cair como gotas chuva
        while(true){
            j+=direcao;
            
            if(j>200){
                j = 50;
                i = new Random().nextInt(600);
                k = new Random().nextInt(255); //
                l = new Random().nextInt(255); //separei essas variáveis para trabalhar as cores do
                m = new Random().nextInt(255);//gradiente RGB no método paint
                
            }
            try{
                Thread.sleep(50);
            }catch(Exception e){}
            repaint();
        }
    }
    
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(10,10,getWidth(),getHeight()); //esse método preenche de branco de modo que "apague"  o desenho anterior, dando a ilusão de movimento.
        //g.setColor(new Color(k,l,m)); //para colorir o desenho em RGB, é preciso instanciar um objeto a partir da classe Color
        g.setColor(Color.RED); //aí a cor fica só vermelha
        g.fillOval(i,j,50,50);
        g.drawString("X = " + String.valueOf(i) + ", Y = " + String.valueOf(j), i - 50, j - 5 );
    }

    public static void main(String[] args) {
        Animacao a = new Animacao();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
 @Override
    public void run(){
 
        while(exe){
           //runn();
           rainDrops();
        repaint();
//        if(j<100){
  //          j+=5;
    //    }
           hideNotify();
        
    }
  }
}
