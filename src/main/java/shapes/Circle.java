package shapes;

import java.awt.*;

/**
 *  The shapes.Circle class encapsulates the information describing a circle and can draw it in a
 * AWT Graphics object using AWT library methods
 * */
public class Circle extends Shape {
    private int rad;

    public Circle(Point initPos, Color col, int radius){
        super(initPos, col);
        rad=radius;
    }

    @Override
    protected void draw(Graphics g) {
        // Fill
        g.setColor(col);
        g.fillOval(pos.x,pos.y,rad, rad);
    }
}