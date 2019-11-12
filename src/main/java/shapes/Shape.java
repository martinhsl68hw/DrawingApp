package shapes;

import java.awt.*;

public abstract class Shape {
    protected int id;
    private static int nextId=1;
    protected Point pos;
    protected Color col;

    public Shape(Point initPos, Color col) {
        id=nextId++;
        pos=initPos;
        this.col=col;
    }

    abstract void draw(Graphics g);
}
