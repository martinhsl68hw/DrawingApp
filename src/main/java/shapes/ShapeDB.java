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
}
