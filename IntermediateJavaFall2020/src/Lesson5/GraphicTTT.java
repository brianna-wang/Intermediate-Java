package Lesson5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraphicTTT extends JPanel {
    char[][] data;
    static int boardWidth=300,N=3;
    static char currPlayer='X';

    public GraphicTTT(){
        data=new char[N][N];
        TTT.initBoard(data);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.print("I detected a mouse click: "+e.getX()+","+e.getY());
                int gridWidth=boardWidth/N;
                int r=e.getY()/gridWidth;
                int c=e.getX()/gridWidth;
                System.out.println("["+r+","+c+"]");
                if(data[r][c]=='_') {
                    data[r][c] = currPlayer;
                    repaint();
                    if (currPlayer == 'X') {
                        currPlayer = 'O';
                    } else {
                        currPlayer = 'X';
                    }
                }
            }
        });
    }
    public void paintComponent (Graphics g){
        int cellWidth=boardWidth/N;
        for(int h=1;h<=N-1;h++){
            int left_x=0;
            int left_y=0+cellWidth*h;
            int right_x=boardWidth;
            int right_y=left_y;
            g.drawLine(left_x,left_y,right_x,right_y);
        }
        for(int v=1;v<=N-1;v++){
            int topX=0+cellWidth*v;
            int topY=0;
            int bottomX=topX;
            int bottomY=boardWidth;
            g.drawLine(topX,topY,bottomX, bottomY);
        }
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                if(data[r][c]!='_'){
                    g.drawString(data[r][c]+" ",0+c*cellWidth+cellWidth/3,0+r*cellWidth+cellWidth/3);
                }
            }
        }
    }
    public static void main (String[] args){
        JFrame myFrame=new JFrame("My First Window!");
        GraphicTTT myPanel=new GraphicTTT();
        myPanel.setPreferredSize(new Dimension(300,300));
        myFrame.add(myPanel);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
        myPanel.setBackground(Color.orange);
    }
}
