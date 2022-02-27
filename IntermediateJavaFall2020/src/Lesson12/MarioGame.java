package Lesson12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MarioGame extends JPanel implements Runnable{
    int panelWidth=1000,panelHeight=500;
    Mario m;
    public MarioGame(){
        setPreferredSize(new Dimension(panelWidth,panelHeight));
        m=new Mario(panelWidth/3,panelHeight);
        new Thread(this).start();
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                System.out.println("key pressed");
                m.goingUp=true;
            }
        });
    }
    public static void main (String[] args){
        JFrame f=new JFrame("Mario Joyride");
        f.setResizable(false);
        MarioGame panel=new MarioGame();
        f.add(panel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    public void paintComponent(Graphics g){
        Image img=Toolkit.getDefaultToolkit().getImage(m.picFile);
        g.drawImage(img,m.x,m.y,m.width,m.height,this);
    }
    public void run(){
        while(true){
            m.move();
            try {
                Thread.sleep(5);
            }catch(InterruptedException e){}
        }
    }
}
