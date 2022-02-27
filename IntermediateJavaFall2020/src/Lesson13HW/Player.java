package Lesson13HW;

public class Player extends Entity {
    int NumOfLives;
    boolean goingUp;
    Player(int mX, int panelHeight){
        width=60;
        height=80;
        x=mX;
        y=panelHeight-height;
        yspeed=2;
        picFile="MarioMedia/mario-running.gif";
    }
    public void move(){
        if(goingUp){
            y=Math.max(y-yspeed,0);
        }
        else{
            y=Math.min(y+yspeed, TheGame.panelHeight-height);
        }
    }
}
