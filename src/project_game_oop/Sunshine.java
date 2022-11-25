/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_game_oop;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;

/**
 *
 * @author yossavadeesukritha
 */
public class Sunshine {
    Image img;
    Image zd;
    public int x = (int) ((Math.random() * 900));
    public int y = 0;
    public int count = 0;
    int w = 100;
    int h = 113;

    Sunshine(){
        String imageLocation = "/image/sunshine.png";
        URL imageURL = this.getClass().getResource(imageLocation);
        img = Toolkit.getDefaultToolkit().getImage(imageURL);
        sun.start();
    }

    Thread sun = new Thread(new Runnable() {     //zombieเคลื่อนที่
        public void run() {
            while (true) {
                y += 5;
                if (y >= 1000) {
                    img = null;
                    sun = null;
                    x = (int) ((Math.random() * 200)+400);;
                    y = -10;
                }
                try {
                     sun.sleep(20);
                } catch (InterruptedException e) {
                }
            }
        }
    });


    public Image getImage() {
        return img;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, w, h));
    }

}

