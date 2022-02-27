package mario;

import java.util.ArrayList;

public class Player extends Entity {
    int NumOfLives;
    boolean goingUp;

    Player(int mX, int panelHeight) {
        width = 60;
        height = 80;
        x = mX;
        y = panelHeight - height;
        yspeed = 2;
        picFile = "MarioMedia/mario-running.gif";
    }

    public Mushroom move(ArrayList<Block> platform) {
        if (goingUp) {
            int afterMoveY = y - yspeed;
            for (Block b : platform) {
                if (afterMoveY >= b.y && afterMoveY <= b.y + b.height && x <= b.x + b.width && x + width >= b.x) {
                    y = b.y + b.height;
                    if(b.hasMushroom){
                        Mushroom m = new Mushroom(b.x,b.y - Mushroom.MUSHROOM_HEIGHT);
                        return m;
                    }else{
                        return null;
                    }
                }
            }
            y = Math.max(y - yspeed, 0);
        } else {
            y = Math.min(y + yspeed, TheGame.panelHeight - height);
        }
        return null;
    }
}
