package Color;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author C0FII
 */
public class DoubleColor {

      JFrame JF = new JFrame();

      public DoubleColor() {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setSize(500, 500);
            Graphics2D g2 = (Graphics2D) JF.getContentPane().getGraphics();

            Color C1 = new Color(91, 195, 233);
            Color C2 = new Color(0, 0, 0);
            //++++++++++++++++++++++++++++++++++
            float rLow = 0.33f;
            float gLow = 0.33f;
            float bLow = 0.34f;
            float rHigh = 0.0f;
            float gHigh = 0.0f;
            float bHigh = 0.0f;

            //float prop = (15 - vLow) / (vHigh - vLow);
            //++++++++++++++++++++++++++++++++++
            g2.setColor(Color.red);
            g2.fillRect(2, 2, 400, 400);

      }

      public static void main(String[] args) {
            new DoubleColor().JF.setVisible(true);
      }
}
