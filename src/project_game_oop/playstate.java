package project_game_oop;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author yossavadeesukritha
 */
public class playstate extends JPanel{
    int delay = 10;

    public boolean over = false;
    private int score=0;
    private int t = 0;
    public ImageIcon bg1 = new ImageIcon(this.getClass().getResource("/image/background.jpeg"));
    public ImageIcon bgover = new ImageIcon(this.getClass().getResource("/image/background2.jpeg"));

    Actor me = new Actor();
    
    public ArrayList<Cloud> c = new ArrayList<Cloud>();
    public ArrayList<Sunshine> s = new ArrayList<Sunshine>();

    
    playstate(){
        this.setFocusable(true);
        this.setSize(1000,813);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int a = e.getKeyCode();
               if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
                   me.x += 50;
                } else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
                   me.x -= 50;
               } 

               repaint();
               actor.start();
            }
        });
        
        delayTime.start();
        time.start();
        newX.start();
        addc.start();
        adds.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg1.getImage(), 0, 0, 1000, 813, this);
        g.drawImage(me.flower.getImage(), me.x, me.y, me.w, me.h, this);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Chiller", Font.CENTER_BASELINE, 50));
        g.drawString("SCORE : " + score, 50, 50);
        g.drawString("Time : " + t, 800, 50);
        //time
        for(int i=delay;i>0;i--){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Chiller", Font.CENTER_BASELINE, 300));
            g.drawString(""+delay,450,400);
        }

           //วาดตัวละคร
        for (int i = 0; i < c.size(); i++) {
            g.drawImage(c.get(i).getImage(), c.get(i).getX(), c.get(i).getY(), 100, 113, this);
        }
        //วาดดวงอาทิด
        for (int i = 0; i < s.size(); i++) {
            g.drawImage(s.get(i).getImage(), s.get(i).getX(), s.get(i).getY(), 100, 113, this);
        }

        //zombieกับตัวละครไหม
        for (int j = 0; j < c.size(); j++) {
            if (Intersect(me.getbound(), c.get(j).getbound())) {
                over = true;
            }
         }
        
        for (int j = 0; j < s.size(); j++) {
            if (Intersect(me.getbound(), s.get(j).getbound())) {
                score += 1;
                s.remove(j);
            }
         }
        
        if(over){
            this.setLayout(null);
            g.drawImage(bgover.getImage(), 0, 0, 1000, 813, this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Chiller", Font.CENTER_BASELINE, 80));
            g.drawString("Game Over",340,300);
            g.drawString("Score "+score,360,400);
        }
       }

    Thread actor = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try {
                    actor.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }
    });

    Thread newX = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if(me.x>=1100){
                        me.x=-30;
                    }else if (me.x < -30){
                        me.x = 1050;
                    }
                    repaint();
                    Thread.sleep(10);
                } catch (Exception e) {
                }
                repaint();
            }
        }
    });

    Thread time = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if(delay<1){
                        t++;
                    }
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }
    });

    Thread addc = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (delay < 1) {
                        if(t<=30){
                            c.add(new Cloud());
                            Thread.sleep(2000);
                        } else if(t<=50) {
                            c.add(new Cloud());
                            Thread.sleep(1000);
                        }else {
                            c.add(new Cloud());
                            Thread.sleep(500);
                        }
                    }
                } catch (Exception e) {
                }
                repaint();
            }
        }
    });
    
    Thread adds = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (delay < 1) {
                        if(t<=30){
                            s.add(new Sunshine());
                            Thread.sleep(2000);
                        } else if(t<=50) {
                            s.add(new Sunshine());
                            Thread.sleep(1000);
                        }else {
                            s.add(new Sunshine());
                            Thread.sleep(500);
                        }
                    }
                } catch (Exception e) {
                }
                repaint();
            }
        }
    });   

    Thread delayTime = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    delay--;
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }
    });

    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }
}
