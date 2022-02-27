package mario;

public class Mushroom extends Entity{
    static int MUSHROOM_HEIGHT=80;

    public Mushroom(int xx, int yy) {
        x = xx;
        y = yy;
        width = MUSHROOM_HEIGHT;
        height = MUSHROOM_HEIGHT;
        xspeed = -1;
        yspeed = -1;
        picFile = "MarioMedia/mario_mushroom.png";
    }
}
