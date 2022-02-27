package Lesson12;

public class Mario extends Entity {
    int NumOfLives;
    boolean goingUp;
    Mario(int mX, int panelHeight){
        width=60;
        height=80;
        x=mX;
        y=panelHeight-height;
        yspeed=2;
        picFile="MarioMedia/mario-running.gif";
    }
    void move(){
        if(goingUp){
            y-=yspeed;
        }
    }
}
