package Lesson9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyEventPanel extends JPanel implements Runnable{
    int dir, panelWidth, x, y;
    int UP=1, DOWN=2, LEFT=3, RIGHT=4;
    KeyEventPanel(int panelWidth){
        new Thread(this).start();
        setFocusable(true);
        this.panelWidth=panelWidth;
        x=panelWidth/2;
        y=panelWidth/2;
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                System.out.println("detecting key pressed: "+e.getKeyCode());
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        System.out.println("UP");
                        dir=1;
                        break;
                    case KeyEvent.VK_DOWN:
                        System.out.println("DOWN");
                        dir=2;
                        break;
                    case KeyEvent.VK_LEFT:
                        System.out.println("LEFT");
                        dir=3;
                        break;
                    case KeyEvent.VK_RIGHT:
                        System.out.println("RIGHT");
                        dir=4;
                        break;
                }
                repaint();
            }
        });
    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        g.setColor(Color.magenta);
        g.fillOval(x,y,20,20);
    }
    public void run(){
        System.out.println("inside run");
        while(true){
            if(dir==UP){
                if(y>=0) {
                    y -= 20;
                }
            }else if(dir==DOWN){
                if(y<=panelWidth-20) {
                    y += 20;
                }
            }else if(dir==LEFT){
                if(x>=0) {
                    x -= 20;
                }
            }else if(dir==RIGHT){
                if(x<=panelWidth-20) {
                    x += 20;
                }
            }
            try {
                Thread.sleep(100);
            }catch(InterruptedException e){}
            repaint();
        }
    }
    public static void main (String[] args){
        JFrame myFrame=new JFrame("KeyEvent Panel");
        int panelWidth=500;
        KeyEventPanel myPanel=new KeyEventPanel(panelWidth);
        myPanel.setPreferredSize(new Dimension(panelWidth,panelWidth));
        myPanel.setBackground(Color.orange);
        myFrame.add(myPanel);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }
}
