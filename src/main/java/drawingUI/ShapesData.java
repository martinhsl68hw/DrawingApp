package drawingUI;

import javax.swing.*;
import java.awt.*;

public class ShapesData extends JPanel {
    private JLabel rects,circs,squares;
    public ShapesData(){
        JPanel labels=new JPanel();
        labels.setLayout(new GridLayout(3,1));
        rects=new JLabel("Rects:");
        circs=new JLabel("Circs:");
        squares=new JLabel("Squares:");
        labels.add(rects);
        labels.add(circs);
        labels.add(squares);
        add(labels);
    }
    public void setRects(int rects){
        this.rects.setText("Rects:"+rects);
    }
    public void setCircs(int circs){
        this.circs.setText("Circles:"+circs);
    }
    public void setSquares(int squares){
        this.squares.setText("Squares:"+squares);
    }
}
