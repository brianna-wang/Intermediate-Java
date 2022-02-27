package FlappyBird;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TheGame extends JPanel implements Runnable {
    static int panelWidth = 1000, panelHeight = 500;
    Bird bird;
    ArrayList<Block> blocks;
    boolean gameOver;
    int score;

    void initGame(){
        setFocusable(true);
        setPreferredSize(new Dimension(panelWidth, panelHeight));
        bird = new Bird(panelWidth, panelHeight);
        blocks = new ArrayList<>();
        score=0;
        new Thread(this).start();
    }
    public TheGame() {
        initGame();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                bird.up();
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(gameOver){
                    gameOver=false;
                    initGame();
                }
            }
        });
        repaint();
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Flappy Bird");
        f.setResizable(false);
        TheGame panel = new TheGame();
        f.add(panel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRect(0, panelHeight - 20, panelWidth, 20);
        bird.draw(g, this);
        for(Block b:blocks){
            g.fillRect(b.x,b.y, Block.BLOCK_SIZE,Block.BLOCK_SIZE);
        }
        if(gameOver){
            g.setColor(Color.blue);
            g.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
            g.drawString("GAME OVER",panelWidth/2,panelHeight/2);
        }
        g.setColor(Color.blue);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        g.drawString("score: "+score,panelWidth-100,50);
    }

    public void run() {
        int counter=0;
        while(!gameOver) {
            counter++;
            if(counter%100==1) {
                int space=(int)((Math.random()*(panelHeight/Block.BLOCK_SIZE-5))+2);
                for (int i = 0; i < (panelHeight/Block.BLOCK_SIZE); i++) {
                    if(i!=space&&i!=space+1) {
                        Block b = new Block(panelWidth + (Block.BLOCK_SIZE), Block.BLOCK_SIZE * i);
                        blocks.add(b);
                    }
                }
            }
            bird.move();
            for (Block b : blocks) {
                b.move();
            }
            for(Block b: blocks){
                if(bird.collidesWith(b)){
                    gameOver=true;
                }
            }
            if(bird.y>panelHeight-20-bird.height||bird.y<bird.height/2){
                gameOver=true;
            }
            for(Block b:blocks){
                if(bird.x==b.x) {
                    score++;
                    break;
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            repaint();
        }
    }
}

