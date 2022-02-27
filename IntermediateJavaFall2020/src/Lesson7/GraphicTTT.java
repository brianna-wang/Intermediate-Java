package Lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraphicTTT extends JPanel {
    char[][] data;
    static int boardWidth=300,N=3, messageAreaHeight=100;
    static char currPlayer='X';
    boolean somebodyWon;
    int status;
    static final int WON=1, TIE=2,PLAYING=3;
    public GraphicTTT(){
        data=new char[N][N];
        Lesson7.TTT.initBoard(data);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.print("I detected a mouse click: "+e.getX()+","+e.getY());
                int gridWidth=boardWidth/N;
                int r=e.getY()/gridWidth;
                int c=e.getX()/gridWidth;
                System.out.println("["+r+","+c+"]");
                if(data[r][c]=='_'&&status==PLAYING) {
                    data[r][c] = currPlayer;
                    boolean win= Lesson7.TTT.checkWin(r,c,data);
                    if(win){
                        System.out.println(currPlayer+" won!");
                        somebodyWon=true;
                        status=WON;
                    }
                    else if(Lesson7.TTT.checkTie(data)){
                        System.out.println("It's a tie!");
                        status=TIE;
                    }
                    else{
                        if (currPlayer == 'X') {
                            currPlayer = 'O';
                        } else {
                            currPlayer = 'X';
                        }
                    }
                    repaint();
                }else{
                    if(status!=PLAYING){
                        TTT.initBoard(data);
                        repaint();
                        currPlayer='X';
                        status=PLAYING;
                    }
                }
            }
        });
    }
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        int cellWidth = boardWidth / N;
        g.setColor(Color.white);
        g.fillRect(0,0,boardWidth,boardWidth);
        g.setColor(Color.black);
        for (int h = 1; h <= N - 1; h++) {
            int left_x = 0;
            int left_y = 0 + cellWidth * h;
            int right_x = boardWidth;
            int right_y = left_y;
            g.drawLine(left_x, left_y, right_x, right_y);
        }
        for (int v = 1; v <= N - 1; v++) {
            int topX = 0 + cellWidth * v;
            int topY = 0;
            int bottomX = topX;
            int bottomY = boardWidth;
            g.drawLine(topX, topY, bottomX, bottomY);
        }
        g.drawLine(0,boardWidth,boardWidth,boardWidth);
        drawPieces(g);
        displayMessages(g);
    }
    void displayMessages(Graphics g){
        if(status==WON) {
            g.drawString(currPlayer + " won!", 50, boardWidth + messageAreaHeight / 2);
            g.drawString("Click anywhere to restart",50,boardWidth+messageAreaHeight/2+30);
        }else if(status==TIE){
            g.drawString("It's a tie!",50,boardWidth+messageAreaHeight/2);
            g.drawString("Click anywhere to restart",50,boardWidth+messageAreaHeight/2+30);

        }else{
            g.drawString(currPlayer+", your turn!",50,boardWidth+messageAreaHeight/2);
        }
    }
    void drawPieces(Graphics g){
        int cellWidth=boardWidth/N;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (data[r][c] != '_') {
                    if (data[r][c] == 'X') {
                        g.drawLine(c * cellWidth, r * cellWidth, (c + 1) * cellWidth, (r + 1) * cellWidth);
                        g.drawLine(c * cellWidth, (r + 1) * cellWidth, (c + 1) * cellWidth, r * cellWidth);
                    } else if (data[r][c] == 'O') {
                        g.drawOval(c * cellWidth, r * cellWidth, cellWidth, cellWidth);
                    }
                }
            }
        }
    }
    public static void main (String[] args){
        JFrame myFrame=new JFrame("My First Window!");
        GraphicTTT myPanel=new GraphicTTT();
        myPanel.setPreferredSize(new Dimension(boardWidth,boardWidth+messageAreaHeight));
        myFrame.add(myPanel);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
        myPanel.setBackground(Color.orange);
    }
}
