package shapes;

import java.awt.*;

public class Rect extends Shape {
    private int width, height;

    public Rect(Point initPos, Color col, int width, int height){
        super(initPos, col);
        this.width=width;
        this.height=height;
    }

    protected void draw(Graphics g) {
        // Fill
        g.setColor(col);
        g.fillRect(pos.x,pos.y,width, height);
    }
}
