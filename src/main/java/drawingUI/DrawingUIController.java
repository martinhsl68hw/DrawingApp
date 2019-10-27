package drawingUI;

import shapes.Drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawingUIController  {
    private JPanel mainPanel;
    private JPanel controlsPanel;
    private Drawing drawing;
    private CircleDescriptor cd;
    private RectDescriptor rd;
    private SquareDescriptor sd;
    private ShapeSelect sSel = new ShapeSelect();
    private ColourSelect cSel=new ColourSelect();

    public DrawingUIController(){
        setUpDrawing();
        instantiateComponents();
        setUpControlsPanel();
        setUpMainPanel();
    }

    private void setUpControlsPanel(){
        controlsPanel=new JPanel();
        controlsPanel.setLayout(new GridLayout(5,1));
        controlsPanel.add(cd);
        controlsPanel.add(rd);
        controlsPanel.add(sd);
        controlsPanel.add(sSel);
        controlsPanel.add(cSel);
    }

    private void setUpMainPanel() {
        mainPanel=new JPanel();
        mainPanel.setLayout(new GridLayout(2,1));
        mainPanel.add(controlsPanel);
        mainPanel.add(drawing);
    }

    private void instantiateComponents() {
        cd=new CircleDescriptor();
        rd=new RectDescriptor();
        sd=new SquareDescriptor();
        sSel=new ShapeSelect();
        cSel=new ColourSelect();
    }

    private void setUpDrawing() {
        drawing=new Drawing();
        drawing.addMouseListener(
            new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                public void mousePressed(MouseEvent e) {
                    if(sSel.getCurrentShape()==ShapeSelect.CIRCLE) {
                        drawing.addCircle(e.getPoint(), cSel.getCurrentColor(), cd.getCurrentRadius());
                    }
                    else if(sSel.getCurrentShape()==ShapeSelect.RECT){
                        drawing.addRect(e.getPoint(), cSel.getCurrentColor(), rd.getCurrentWidth(),rd.getCurrentHeight());
                    }
                    else if(sSel.getCurrentShape()==ShapeSelect.SQUARE){
                        drawing.addSquare(e.getPoint(), cSel.getCurrentColor(), sd.getCurrentSide());
                    }
                    drawing.invalidate();
                    drawing.repaint();
                    System.out.println("Mouse was pressed");
                }

                public void mouseEntered(MouseEvent arg0) {
                }

                public void mouseExited(MouseEvent arg0) {
                }

                public void mouseReleased(MouseEvent arg0) {
                }
            });
    }
    public JPanel getMainPanel(){
        return mainPanel;
    }
}
