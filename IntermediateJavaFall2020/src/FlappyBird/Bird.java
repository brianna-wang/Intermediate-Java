package FlappyBird;

import java.awt.*;

public class Bird extends Entity{
    public Bird(int panelWidth,int panelHeight){
        width=40;
        height=40;
        x=panelWidth/4;
        y=panelHeight/2;
        ySpeed=20;
        picFile="FlappyBirdMedia/flappy_bird.png";
    }
    void up(){
        y-=40;
    }
}
