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
    private ShapesData shapesData;
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
        controlsPanel.setLayout(new GridLayout(3,2));

        controlsPanel.add(rd);
        controlsPanel.add(cd);
        controlsPanel.add(sd);
        controlsPanel.add(sSel);
        controlsPanel.add(cSel);
        controlsPanel.add(shapesData);

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
        shapesData=new ShapesData();
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
                    drawing.repaint();
                    System.out.println("Mouse was pressed");
                    shapesData.setCircs(drawing.getNumCircles());
                    shapesData.setRects(drawing.getNumRects());
                    shapesData.setSquares(drawing.getNumSquares());
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


