/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package tankrotationexample;


import com.sun.corba.se.spi.ior.ObjectKey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import  java.io.File;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList.*;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import static javax.imageio.ImageIO.read;


public class SuperRainbow extends JPanel {
    //size of the screen
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 1080;

    private BufferedImage sea;
    private Graphics2D buffer;
    private JFrame jf;
    private Kutch k1;
    private pop p1;
    public reefHealth kh;
    public reefScore sc1, sc2, sc3, sc4, sc5, tsc;

    public LinkedList<gameObject> delete_list;

    public LinkedList<gameObject> Bricks;

    public void balls (pop pops)
    {
        this.Bricks.add(pops);
    }

    public static void main(String[] args) {
        Thread x;
        SuperRainbow trex = new SuperRainbow();
        trex.init();
        try {
            while (true) {
                if(trex.k1 != null)
                trex.k1.update();
                for (Object object : trex.Bricks) {
                    gameObject element = (gameObject) object;
                    element.update(SuperRainbow.SCREEN_WIDTH, SuperRainbow.SCREEN_HEIGHT);
                }
                trex.repaint();

                Thread.sleep(1000 / 70);
            }
        } catch (InterruptedException ignored) {

        }

    }

    public void init() {
        this.jf = new JFrame("Kutch");
        this.Bricks = new LinkedList<gameObject>();
        this.delete_list = new LinkedList<gameObject>();

        // boarders

        Bricks.add(new reefBricks(6,100,50,900,1,false));
        Bricks.add(new reefBricks(6,100,50,900,0, false));
        Bricks.add(new reefBricks(6,1000,50,900,0,false));


        // wall of bricks go here

        // row 1
        Bricks.add(new reefBricks(1,410,150,50,1,true));
        Bricks.add(new reefBricks(5,465,150,50,1,true));
        Bricks.add(new reefBricks(5,520,150,50,1,true));
        Bricks.add(new reefBricks(5,580,150,50,1,true));
        Bricks.add(new reefBricks(2,635,150,50,1, true));
        // row 2
        Bricks.add(new reefBricks(2,355,200,50,1, true));
        Bricks.add(new reefBricks(1,410,200,50,1,true));
        Bricks.add(new reefBricks(4,465,200,50,1,true));
        Bricks.add(new reefBricks(2,520,200,50,1,true));
        Bricks.add(new reefBricks(1,580,200,50,1,true));
        Bricks.add(new reefBricks(2,635,200,50,1, true));
        Bricks.add(new reefBricks(2,690,200,50,1,true));

        // row 3
        Bricks.add(new reefBricks(1,300,250,50,1,true));
        Bricks.add(new reefBricks(2,355,250,50,1,true));
        Bricks.add(new reefBricks(2,355,250,50,1, true));
        Bricks.add(new reefBricks(1,410,250,50,1,true));
        Bricks.add(new reefBricks(4,465,250,50,1,true));
        Bricks.add(new reefBricks(3,520,250,50,1,true));
        Bricks.add(new reefBricks(1,580,250,50,1,true));
        Bricks.add(new reefBricks(2,635,250,50,1, true));
        Bricks.add(new reefBricks(2,690,250,50,1,true));
        Bricks.add(new reefBricks(4,745,250,50,1,true));


        //r0w 4
        Bricks.add(new reefBricks(2,245,300,50,1,true));
        Bricks.add(new reefBricks(1,300,300,50,1,true));
        Bricks.add(new reefBricks(2,355,300,50,1, true));
        Bricks.add(new reefBricks(2,410,300,50,1,true));
        Bricks.add(new reefBricks(4,465,300,50,1,true));
        Bricks.add(new reefBricks(2,520,300,50,1,true));
        Bricks.add(new reefBricks(1,580,300,50,1,true));
        Bricks.add(new reefBricks(2,635,300,50,1, true));
        Bricks.add(new reefBricks(2,690,300,50,1,true));
        Bricks.add(new reefBricks(4,745,300,50,1,true));
        Bricks.add(new reefBricks(4,800,300,50,1,true));

        // row 5
        Bricks.add(new reefBricks(4,190,350,50,1,true));
        Bricks.add(new reefBricks(3,245,350,50,1,true));
        Bricks.add(new reefBricks(1,300,350,50,1,true));
        Bricks.add(new reefBricks(5,355,350,50,1, true));
        Bricks.add(new reefBricks(5,410,350,50,1,true));
        Bricks.add(new reefBricks(5,465,350,50,1,true));
        Bricks.add(new reefBricks(5,520,350,50,1,true));
        Bricks.add(new reefBricks(5,580,350,50,1,true));
        Bricks.add(new reefBricks(5,635,350,50,1, true));
        Bricks.add(new reefBricks(5,690,350,50,1,true));
        Bricks.add(new reefBricks(4,745,350,50,1,true));
        Bricks.add(new reefBricks(3,800,350,50,1,true));
        Bricks.add(new reefBricks(2,855,350,50,1,true));
        // row 6
        Bricks.add(new reefBricks(1,245,400,50,1,true));
        Bricks.add(new reefBricks(1,300,400,50,1,true));
        Bricks.add(new reefBricks(2,355,400,50,1, true));
        Bricks.add(new reefBricks(2,410,400,50,1,true));
        Bricks.add(new reefBricks(1,465,400,50,1,true));
        Bricks.add(new reefBricks(4,520,400,50,1,true));
        Bricks.add(new reefBricks(1,580,400,50,1,true));
        Bricks.add(new reefBricks(2,635,400,50,1, true));
        Bricks.add(new reefBricks(1,690,400,50,1,true));
        Bricks.add(new reefBricks(4,745,400,50,1,true));
        Bricks.add(new reefBricks(4,800,400,50,1,true));


        //row 7
        Bricks.add(new reefBricks(1,300,450,50,1,true));
        Bricks.add(new reefBricks(2,355,450,50,1, true));
        Bricks.add(new reefBricks(1,410,450,50,1,true));
        Bricks.add(new reefBricks(4,465,450,50,1,true));
        Bricks.add(new reefBricks(2,520,450,50,1,true));
        Bricks.add(new reefBricks(1,580,450,50,1,true));
        Bricks.add(new reefBricks(2,635,450,50,1, true));
        Bricks.add(new reefBricks(3,690,450,50,1,true));
        Bricks.add(new reefBricks(4,745,450,50,1,true));

        //row 8
        Bricks.add(new reefBricks(2,355,500,50,1, true));
        Bricks.add(new reefBricks(2,410,500,50,1,true));
        Bricks.add(new reefBricks(4,465,500,50,1,true));
        Bricks.add(new reefBricks(1,520,500,50,1,true));
        Bricks.add(new reefBricks(1,580,500,50,1,true));
        Bricks.add(new reefBricks(2,635,500,50,1, true));
        Bricks.add(new reefBricks(3,690,500,50,1,true));

        // row 9
        Bricks.add(new reefBricks(2,410,550,50,1,true));
        Bricks.add(new reefBricks(5,465,550,50,1,true));
        Bricks.add(new reefBricks(5,520,550,50,1,true));
        Bricks.add(new reefBricks(5,580,550,50,1,true));
        Bricks.add(new reefBricks(2,635,550,50,1, true));


        // shows point values
        Bricks.add(new reefBricks(1,1050,550,50,1,true));
        Bricks.add(new reefBricks(2,1050,600,50,1,true));
        Bricks.add(new reefBricks(3,1050,650,50,1,true));
        Bricks.add(new reefBricks(4,1050,700,50,1,true));
        Bricks.add(new reefBricks(5,1050,750,50,1, true));

        // buffers the world
        this.sea = new BufferedImage(SuperRainbow.SCREEN_WIDTH, SuperRainbow.SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);




        kh = new reefHealth(1100,100,3,0);
        k1 = new Kutch (480,900,0,0,80, 1, this);
        p1 = new pop (450,800,0,0,this,k1);

        // shows the score for each brick
        sc1 = new reefScore(1,1110,550,100,this, k1);
        sc2 = new reefScore(2,1110,600,100,this, k1);
        sc3 = new reefScore(3,1110,650,100,this, k1);
        sc4 = new reefScore(4,1110,700,200,this, k1);
        sc5 = new reefScore(5,1110,750,500,this, k1);
      // tsc = new reefScore(6,1110,200,1,this,k1);


        Bricks.add(k1);


        //Bricks.add(p1);

        reefControls kutch = new reefControls(k1, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, this);
        this.jf.addKeyListener(kutch);
        this.jf.setLayout(new BorderLayout());
        this.jf.add(this);


        //this.jf.addKeyListener(k1);

        this.jf.addKeyListener(kutch);


        this.jf.setSize(SuperRainbow.SCREEN_WIDTH, SuperRainbow.SCREEN_HEIGHT + 30);
        this.jf.setBackground(Color.BLACK);
        this.jf.getContentPane().setBackground(Color.black);
        this.jf.setResizable(false);
        jf.setLocationRelativeTo(null);

        this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jf.setVisible(true);

    }


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        this.sea = new BufferedImage(SuperRainbow.SCREEN_WIDTH, SuperRainbow.SCREEN_HEIGHT + 30, BufferedImage.TYPE_INT_RGB);
        buffer = sea.createGraphics();
        super.paintComponent(g2);
        g2.drawImage(sea,null,0,0);
        p1.drawImage(g2);
        sc1.Draw(g2);
        sc2.Draw(g2);
        sc3.Draw(g2);
        sc4.Draw(g2);
        sc5.Draw(g2);


        //this.k1.drawImage(buffer);

        for(Object object : delete_list) {
            gameObject element = (gameObject) object;
            if (!element.is_visible()) {
                System.out.println("Deleted");
                Bricks.remove(object);
            }
        }

        delete_list.clear();

        for(Object object : Bricks) {
            gameObject element = (gameObject) object;
            element.drawImage(g2);

        }

        this.kh.draw(g2);


    }
}