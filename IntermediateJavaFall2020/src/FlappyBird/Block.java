package FlappyBird;

public class Block extends Entity{
    static int BLOCK_SIZE=50;
    public Block(int xx, int yy){
        width=BLOCK_SIZE;
        height=BLOCK_SIZE;
        x=xx;
        y=yy;
        xSpeed=-5;
        ySpeed=0;
    }
}
