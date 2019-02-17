import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;

public class TestGUI implements ActionListener{
  private JPanel rightPanel = new JPanel();
  private JButton button = new JButton("draw");
  private ArrayList<JSpinner> spinners = new ArrayList<>();
  private MaficRockGraph maficRockGraph = new MaficRockGraph();

  public void actionPerformed(ActionEvent x){
    maficRockGraph.repaint();
  }

  private class MaficRockGraph extends JPanel {

    public void paintComponent(Graphics g) {
      g.setColor(Color.white);
      g.fillRect(0,0,this.getWidth(),this.getHeight());

      //make the cpx - ol - opx triangle
      g.setColor(Color.black);
      int[] xcoords = new int[]{50, 150, 250, 50};
      int[] ycoords = new int[]{250, 50, 250, 250};
      for (int i = 0; i < 3; i++) {
        g.drawLine(xcoords[i], ycoords[i], xcoords[i + 1], ycoords[i + 1]);
      }

      // add labels
      g.drawString("cpx",240,260);
      g.drawString("ol",145,40);
      g.drawString("opx",40,260);

      //draw rock with user input composition normalized to 100
      int cpx = (int) spinners.get(0).getValue();
      int ol = (int) spinners.get(1).getValue();
      int opx = (int) spinners.get(2).getValue();
      int total = cpx + ol + opx;
      ol = (ol*100)/total;
      cpx = (cpx*100)/total;

      g.fillRect(((cpx+ol/2)*200/100+50-5),
          ((((100-ol)*200/100))+50-5),
          10,
          10);
    }
  }

  void makeUltramaficRockClassificationGUI(){
    JFrame frame = new JFrame();

    // make the 3 spinners and associated labels
    String[] labels = {"cpx [%]", "ol [%]", "opx [%]"};

    // initialize user input fields
    for(String label: labels){
      SpinnerNumberModel model = new SpinnerNumberModel(50, 0, 100, 1);
      JSpinner s = new JSpinner(model);
      JLabel l = new JLabel(label);
      l.setLabelFor(s);
      spinners.add(new JSpinner(model));
      rightPanel.add(l);
      rightPanel.add(s);
    }

    button.addActionListener(this);
    rightPanel.add(button);
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(350,350);
    frame.getContentPane().add(BorderLayout.CENTER,maficRockGraph);
    frame.getContentPane().add(BorderLayout.EAST,rightPanel);
    frame.setVisible(true);
  }}
