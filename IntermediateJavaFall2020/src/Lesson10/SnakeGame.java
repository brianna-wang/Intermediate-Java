package Lesson10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class SnakeGame extends JPanel implements Runnable{
    int dir, panelWidth, snakeWidth, x, y;
    int UP=1, DOWN=2, LEFT=3, RIGHT=4;
    ArrayList<Point> snake;
    Point apple;
    SnakeGame(int panelWidth){
        setFocusable(true);
        this.panelWidth=panelWidth;
        snakeWidth=20;
        dir=LEFT;
        x=(panelWidth/2)/snakeWidth*snakeWidth;
        y=(panelWidth/2)/snakeWidth*snakeWidth;
        apple=new Point();
        apple.x=(int)(Math.random()*(panelWidth-snakeWidth));
        apple.y=(int)(Math.random()*(panelWidth-snakeWidth));
        apple.x=apple.x/snakeWidth*snakeWidth;
        apple.y=apple.y/snakeWidth*snakeWidth;
        snake=new ArrayList<>();
        snake.add(new Point(x,y));
        snake.add(new Point(x+snakeWidth,y));
        snake.add(new Point(x+2*snakeWidth,y));
        snake.add(new Point(x+3*snakeWidth,y));
        new Thread(this).start();
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
        for(int i=0;i<snake.size();i++) {
            g.setColor(Color.magenta);
            g.fillOval(snake.get(i).x, snake.get(i).y, snakeWidth, snakeWidth);
        }
        g.setColor(Color.red);
        g.fillOval(apple.x,apple.y,snakeWidth,snakeWidth);
    }
    public void run(){
        System.out.println("inside run");
        while(true){
            Point newHead=null;
            if(dir==UP){
                newHead= new Point(snake.get(0).x,snake.get(0).y-snakeWidth);
            }else if(dir==DOWN){
                newHead= new Point(snake.get(0).x,snake.get(0).y+snakeWidth);
            }else if(dir==LEFT){
                newHead= new Point(snake.get(0).x-snakeWidth,snake.get(0).y);
            }else if(dir==RIGHT){
                newHead= new Point(snake.get(0).x+snakeWidth,snake.get(0).y);
            }
            snake.add(0, newHead);
            if(snake.contains(apple)){
                apple.x=(int)(Math.random()*(panelWidth-snakeWidth));
                apple.y=(int)(Math.random()*(panelWidth-snakeWidth));
                apple.x=apple.x/snakeWidth*snakeWidth;
                apple.y=apple.y/snakeWidth*snakeWidth;
            }else{
                snake.remove(snake.size() - 1);
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
        SnakeGame myPanel=new SnakeGame(panelWidth);
        myPanel.setPreferredSize(new Dimension(panelWidth,panelWidth));
        myPanel.setBackground(Color.orange);
        myFrame.add(myPanel);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }
}
