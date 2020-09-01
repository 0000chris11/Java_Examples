
package Layouts;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;
/**
 *
 * @author Christopher
 */
public class Main {
      
      JFrame JF = new JFrame();
      static JPanel[] JPS = new JPanel[]{
            new PanelG(null), 
            new PanelG("miglayout"),//"miglayout" 
            new PanelG("boxlayout"),//"boxlayout" 
            new PanelG(null)};
      static JButton[] JBTNS = new JButton[]{
            new Button(null), 
            new Button("miglayout"),
            new Button("boxlayout")};
      
      public Main(){
            JF.setTitle("Layout Test");
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setAlwaysOnTop(true);
            //JF.setLayout(new BoxLayout(JF.getContentPane(), BoxLayout.X_AXIS));
            JF.setLayout(null);
            int d = 2;
            int sX = 0;
            int bs = 4;
            for(int a = 0; a < 3; a++){
                  setName(JPS[a], ("JP_" + (a + 1)));
                  JF.add(JPS[a]);
                  //JPS[a].setBackground(Color.BLACK);
                  JPS[a].setLocation(d,2);
                  d+= 302;
                  sX += JPS[a].getWidth();
                  for(int b = 0; b < JBTNS.length; b++){
                        //System.out.println(JPS[a].getName() + ": " + JBTNS[b].getName());
                        setName(JBTNS[b], ("BTN_" + (b + 1)));
                        JPS[a].add(JBTNS[b]);
                        JBTNS[b].setLocation(4, bs);
                        bs += 44;
                        //JPS[a].add
                  }
            }
            //+++++++++++++++++++++++
            JF.setSize(sX + 24, JPS[0].getHeight() + 44);
            JF.setVisible(true);
      }
      
      public void setName(JComponent jc, String name){
            jc.setName(name);
      }
      
      public static void main(String[] args){
            new Main();
            new Second();
      }
}
