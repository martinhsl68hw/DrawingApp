package drawingUI;

import javax.swing.*;
import java.awt.*;

public class SquareDescriptor extends JPanel {
    private JSlider sideSlider;
    public SquareDescriptor(){
        JPanel controls=new JPanel();
        sideSlider=new JSlider(1,100);
        controls.setLayout(new GridLayout(2,1));
        controls.add(new JLabel("Square Side"));
        controls.add(sideSlider);
        add(controls);
    }
    public int getCurrentSide() {
        return sideSlider.getValue();
    }
}
