import drawingUI.DrawingUIController;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static GraphicsConfiguration gc;
    public static void main(String args[]){
        JFrame frame= new JFrame(gc);
        DrawingUIController drawingUIController=new DrawingUIController();
        frame.getContentPane().add(drawingUIController.getMainPanel());
        frame.setSize(500,600);
        frame.setVisible(true);

        // This next line closes the program when the frame is closed
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
