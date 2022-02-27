package Lesson14HW;

import java.util.ArrayList;

public class Mushroom extends Entity {
    static int MUSHROOM_HEIGHT=80;

    public Mushroom(int xx, int yy) {
        x = xx;
        y = yy;
        width = MUSHROOM_HEIGHT;
        height = MUSHROOM_HEIGHT;
        xspeed = 0;
        yspeed = 1;
        picFile = "MarioMedia/mario_mushroom.png";
    }
    public void moveMush(ArrayList<Block> platform) {
        for (Block b : platform) {
            int afterMoveY = y + yspeed + height;
            if (afterMoveY >= b.y && afterMoveY <= b.y + b.height && x <= b.x + b.width && x + width >= b.x) {
                y = b.y - height;
                return;
            }
        }
        y=Math.min(y+yspeed, TheGame.panelHeight-height);
    }
}
