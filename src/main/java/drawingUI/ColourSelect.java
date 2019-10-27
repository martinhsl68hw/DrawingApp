package drawingUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColourSelect extends JPanel {
    JButton but;
    private Color currentColor=Color.BLACK;

    public ColourSelect(){
        but=new JButton("Select");

        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(
                        but,
                        "Choose Colour",
                        currentColor);
                currentColor=newColor;
                but.setBackground(currentColor);

            }
        });
        add(but);
    }
    public Color getCurrentColor(){
        return currentColor;
    }
}
