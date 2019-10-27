package shapes;

import java.awt.*;
import java.util.ArrayList;

public class ShapeDB {
    private ArrayList<Shape> shapes;
    public ShapeDB(){
        shapes=new ArrayList<Shape>();
    }
    public void addCircle(Point pos, Color col, int radius){
        shapes.add(new Circle(pos,col,radius));
    }
    public void addRect(Point pos, Color col, int w, int h){
        shapes.add(new Rect(pos,col,w,h));
    }
    public void addSquare(Point pos, Color col, int side){
        shapes.add(new Square(pos,col,side));
    }
    public void drawShapes(Graphics g){
        for(Shape p:shapes)
            p.draw(g);
    }

    private int getCount(Class a){
        int count=0;
        for(Shape p:shapes){
            if (p.getClass() == a) count++;
        }
        return count;
    }
    int getNumCircles() {
        return getCount(Circle.class);
    }
    int getNumRects() {
        return getCount(Rect.class);
    }
    int getNumSquares() {
        return getCount(Square.class);
    }

}
