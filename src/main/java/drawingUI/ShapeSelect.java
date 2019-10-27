package drawingUI;

import javax.swing.*;

public class ShapeSelect extends JPanel {
    public static final int SQUARE=1;
    public static final int CIRCLE=2;
    public static final int RECT=3;
    JRadioButton bCirc,bRect,bSquare;


    private int currentShape=RECT;

    public ShapeSelect(){
        ButtonGroup bg = new ButtonGroup();
        bCirc = new JRadioButton("Circle");
        bRect = new JRadioButton("Rect");
        bSquare = new JRadioButton("Square");
        bg.add(bCirc);
        bg.add(bRect);
        bg.add(bSquare);
        add(bCirc);
        add(bRect);
        add(bSquare);
        bRect.setSelected(true);
    }

    public int getCurrentShape(){
        if(bCirc.isSelected())return CIRCLE;
        else if(bRect.isSelected())return RECT;
        else return SQUARE;
    }
}
