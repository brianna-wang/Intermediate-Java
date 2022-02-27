package Lesson4;

import javax.swing.*;
import java.awt.*;

public class MyFirstPanel extends JPanel {
    public void paintComponent (Graphics g){
        g.drawLine(30,50,70,100);
        g.setColor(Color.magenta);
        g.drawLine(0,100,300,100);
        g.drawLine(0,200,300,200);
        g.setColor(Color.blue);
        g.drawRect(20,20,260,260);
        g.fillRect(100,100,100,100);
        g.drawOval(50,30,200,50);
        g.drawString("HELLO",30,270);
    }
    public static void main (String[] args){
        JFrame myFrame=new JFrame("My First Window!");
        MyFirstPanel myPanel=new MyFirstPanel();
        myPanel.setPreferredSize(new Dimension(300,300));
        myPanel.setBackground(Color.orange);
        myFrame.add(myPanel);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }
}
