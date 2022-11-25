/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project_game_oop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author yossavadeesukritha
 */
public class Project_Game_OOP extends JFrame implements ActionListener {
    Home home = new Home();
    playstate p = new playstate();

    public Project_Game_OOP() {
        this.setSize(1000,813);
        this.add(home);
        home.start.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == home.start) {
            this.setLocationRelativeTo(null);
            this.remove(home);
            this.setSize(1000, 813);
            this.add(p);
            p.requestFocusInWindow();
            repaint();
        }
    }


    public static void main(String[] args) {
        JFrame jf = new Project_Game_OOP();
        jf.setSize(1000,813);
        jf.setTitle("Flower need sunshine");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
}

