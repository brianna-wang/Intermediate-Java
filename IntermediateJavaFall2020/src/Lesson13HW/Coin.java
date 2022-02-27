package Lesson13HW;

public class Coin extends Entity {
    static int COIN_SIZE=30;
    public Coin(int xx,int yy){
        x=xx;
        y=yy;
        width=COIN_SIZE;
        height=COIN_SIZE;
        xspeed=-1;
        yspeed=0;
        picFile="MarioMedia/mario_coin.gif";
        soundFile="MarioMedia/smb_coin.wav";
    }
}
