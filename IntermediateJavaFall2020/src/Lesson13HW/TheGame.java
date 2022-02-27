package Lesson13HW;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class TheGame extends JPanel implements Runnable{
    static int panelWidth=1000,panelHeight=500;
    Player m;
    ArrayList<Coin> coins;
    ArrayList<Enemy> enemy;
    int score;
    boolean gameOver;
    void initGame(){
        setPreferredSize(new Dimension(panelWidth,panelHeight));
        m=new Player(panelWidth/3,panelHeight);
        coins=new ArrayList<>();
        enemy=new ArrayList<>();
        score=0;
        new Thread(this).start();
        setFocusable(true);
    }
    public TheGame(){
        initGame();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                System.out.println("key pressed");
                m.goingUp=true;
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                m.goingUp=false;
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(gameOver){
                    gameOver=false;
                    initGame();
                    repaint();
                }
            }
        });
    }
    public static void main (String[] args){
        JFrame f=new JFrame("Mario Joyride");
        f.setResizable(false);
        TheGame panel=new TheGame();
        f.add(panel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Coin c:coins){
            c.draw(g,this);
        }
        g.setColor(Color.BLUE);
        g.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        g.drawString("Score: "+score,25,25);
        m.draw(g,this);
        for(Enemy e:enemy) {
            e.draw(g,this);
        }
        if(gameOver){
            g.setColor(Color.BLUE);
            g.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
            g.drawString("Game Over",panelWidth/2,panelHeight/2);
        }
    }
    public void run(){
        int counter=0;
        while(!gameOver){
            counter++;
            m.move();
            for(Coin c:coins){
                c.move();
            }
            for(Enemy e:enemy){
                e.move();
            }
            for(int i=0;i<coins.size();i++) {
                if (m.collidesWith(coins.get(i))) {
                    coins.remove(coins.get(i));
                    i--;
                    score += 10;
                    playSound(Coin.soundFile);
                }
            }
            for(int i=0;i<enemy.size();i++){
                if(m.collidesWith(enemy.get(i))){
                    gameOver=true;
                }
            }
            if(counter%500==1){
                int numR=(int)(Math.random()*5);
                int numC=(int)(Math.random()*7);
                int startY=(int)(Math.random()*(panelHeight- Coin.COIN_SIZE));
                for(int r=0;r<numR;r++){
                    for(int c=0;c<numC;c++){
                        int x=panelWidth+(Coin.COIN_SIZE+10)*c;
                        int y=startY+(Coin.COIN_SIZE+10)*r;
                        Coin aCoin=new Coin(x,y);
                        coins.add(aCoin);
                    }
                }
            }
            if(counter%700==1){
                int x=panelWidth+ Enemy.enemySize;
                int y=(int)(Math.random()*panelHeight);
                Enemy e=new Enemy(x,y);
                enemy.add(e);
            }
            try {
                Thread.sleep(10);
            }catch(InterruptedException e){}
        repaint();
        }
    }
    static void playSound(String soundFile) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFile).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(0);
        } catch (Exception exception){
        }
    }
}
