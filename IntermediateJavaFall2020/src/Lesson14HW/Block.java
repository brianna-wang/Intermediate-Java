package Lesson14HW;

public class Block extends Entity {
    static int BLOCK_SIZE = 50;
    boolean hasMushroom;

    public Block(int xx, int yy) {
        int r = (int) (Math.random() * 10);
        if (r == 1) {
            hasMushroom = true;
            picFile = "MarioMedia/mario_question_block.png";
        } else {
            picFile = "MarioMedia/mario_block.png";
        }
        x = xx;
        y = yy;
        width = BLOCK_SIZE;
        height = BLOCK_SIZE;
        xspeed = -1;
        yspeed = 0;
    }
}
