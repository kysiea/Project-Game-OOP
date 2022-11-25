/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_game_oop;

import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

/**
 *
 * @author yossavadeesukritha
 */
public class Actor {
    int x = 443;
    int y = 600;
    int w = 100;
    int h = 141;

    public ImageIcon flower = new ImageIcon(this.getClass().getResource("/image/flower1.png"));
    Actor(){
    }
    public Rectangle2D getbound(){
        return (new Rectangle2D.Double(x,y,100,130));
    }
}

