package FlappyBird;

import java.awt.*;

public class Entity {
    int x, y, xSpeed,ySpeed,width,height;
    String picFile;
    void move(){
        x+=xSpeed;
        y+=ySpeed;
    }
    void draw(Graphics g, TheGame panel){
        Image img=Toolkit.getDefaultToolkit().getImage(picFile);
        g.drawImage(img,x,y,width,height,panel);
    }
    boolean collidesWith(Entity e2) {
        boolean aboveE2 = y + height < e2.y;
        boolean belowE2 = y > e2.y;
        boolean leftOfE2 = x + width < e2.x;
        boolean rightOfE2 = x > e2.x + e2.width;
        boolean noCollide = aboveE2 || belowE2 || leftOfE2 || rightOfE2;
        return !noCollide;
    }
}
