package shapes;

import shapes.Circle;
import shapes.Rect;
import shapes.ShapeDB;
import shapes.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Drawing extends Canvas {

    ShapeDB shapeDB;

    public Drawing(){
        setupCanvas();
        shapeDB=new ShapeDB();
    }

    private void setupCanvas() {
        setBackground(Color.WHITE);
        setSize(500, 100);
        setVisible(true);

    }
    public void addCircle(Point pos, Color col, int radius){
        shapeDB.addCircle(pos,col,radius);
    }
    public void addRect(Point pos, Color col, int w, int h){
        shapeDB.addRect(pos,col,w,h);
    }
    public void addSquare(Point pos, Color col, int side){

        shapeDB.addSquare(pos,col,side);
    }

    public void paint(Graphics g){
        shapeDB.drawShapes(g);
    }
}
