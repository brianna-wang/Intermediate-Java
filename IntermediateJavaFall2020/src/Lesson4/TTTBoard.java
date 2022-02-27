package Lesson4;

import javax.swing.*;
import java.awt.*;

public class TTTBoard extends JPanel {
    static int boardWidth=300,N=3;
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
    }
    public static void main (String[] args){
        JFrame myFrame=new JFrame("My First Window!");
        TTTBoard myPanel=new TTTBoard();
        myPanel.setPreferredSize(new Dimension(300,300));
        myPanel.setBackground(Color.orange);
        myFrame.add(myPanel);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }
}
