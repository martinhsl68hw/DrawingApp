package drawingUI;

import javax.swing.*;
import java.awt.*;

public class RectDescriptor extends JPanel {
    private JSlider widthSlider;
    private JSlider heightSlider;
    private JPanel controls;

    private int width=0;
    private int height=0;
    public RectDescriptor(){
        controls= new JPanel();
        widthSlider=new JSlider(1,100);
        heightSlider=new JSlider(1,100);
        controls.setLayout(new GridLayout(4,1));
        controls.add(new JLabel("Rect Width and Height"));
        controls.add(widthSlider);
        controls.add(heightSlider);
        add(controls);
    }
    public int getCurrentWidth(){
        return widthSlider.getValue();
    }
    public int getCurrentHeight(){
        return heightSlider.getValue();
    }

}
