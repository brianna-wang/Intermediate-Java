package Lesson13HW;

public class Enemy extends Entity {
    static int enemySize=60;
    public Enemy(int xx,int yy){
        x=xx;
        y=yy;
        width=enemySize;
        height=enemySize;
        xspeed=-1;
        yspeed=0;
        picFile="MarioMedia/mario_koopa.gif";
    }
}
