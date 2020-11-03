package String;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.GradientPaint;
import javax.swing.JButton;

/**
 *
 * @author Christopher
 */
public class FontMetrics_ex {

      JFrame JF = new JFrame();
      static final Font F = new Font("Dialog", Font.PLAIN, 30);
      static ArrayList<Shape> listS = new ArrayList<Shape>();

      static String S = "Here!";

      static JPanel JP = new JPanel() {
            public void paintComponent(Graphics g) {
                  super.paintComponent(g);
                  System.out.println("paintComponent");

                  String S = "Word";

                  Graphics2D g2 = (Graphics2D) g;
                  //+++++++++++++++++++++++++++++++++++++++
                  g2.setFont(F);
                  g2.setColor(Color.RED);
                  setCenterString(g2, S, getWidth(), getHeight());
                  //+++++++++++++++++++++++++++++++++++++++
                  g2.setColor(Color.WHITE);
                  Line2D Hlin = new Line2D.Float(10, 100, 190, 100);
                  g2.draw(Hlin);

                  g2.setColor(Color.WHITE);
                  Line2D Vlin = new Line2D.Float(100, 10, 100, 190);
                  g2.draw(Vlin);
                  //++++++++++++++++++++++++++++++++++++++++++++
                  setOutline(g2, S, F, getWidth(), getHeight());
            }
      };

      static JPanel JP2 = new JPanel();

      static JButton JBTN = new JButton() {
            public void paintComponent(Graphics g) {
                  super.paintComponent(g);
                  Graphics2D g2 = (Graphics2D) g;
                  //System.out.println("" + this.getModel().isPressed());
                  if (!getModel().isPressed()) {
                        System.out.println("\tNormal");
                        g2.setPaint(getCelesteGP(getWidth(), getHeight(), true));
                  } else {
                        System.out.println("\tSelected");
                        g2.setPaint(getCelesteGP(getWidth(), getHeight(), false));
                  }
                  g2.fillRect(0, 0, getWidth(), getHeight());
                  //g2.create();
                  setOutline(g2, S, F, getWidth(), getHeight());
                  //g2.create();
                  //g2.translate(0, 0);

            }
      };

      public FontMetrics_ex() {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setLayout(null);
            JF.setSize(640, 244);
            JF.setVisible(true);
            //JP.setLayout(null);
            JP.setLocation(2, 2);
            JP.setSize(200, 200);
            JP.setBackground(Color.BLACK);
            //JP.setVisible(true);

            JP2.setLocation(JP.getWidth() + 4, 2);
            JP2.setSize(200, 200);
            JP2.setBackground(Color.BLACK);

            JBTN.setLocation(JP.getWidth() + JP2.getWidth() + 8, 2);
            JBTN.setSize(200, 200);
            //JP2.setVisible(true);
            //JF.pack();
            JF.add(JP);
            JF.add(JP2);
            JF.add(JBTN);
            createGraphicsFromJP2();
      }

      private static void setCenterString(Graphics g, String s, int w, int h) {
            FontMetrics FM = g.getFontMetrics();
            int x = (w - FM.stringWidth(s)) / 2;
            int y = (FM.getAscent() + (h - (FM.getAscent() + FM.getDescent())) / 2);
            g.drawString(s, x, y);
      }

      private static void setOutline(Graphics2D g2, String s, Font f, int w, int h) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);

            FontRenderContext frc = g2.getFontRenderContext();
            TextLayout tl = new TextLayout(s, f, frc);
            AffineTransform transform = new AffineTransform();

            Shape outline = tl.getOutline(null);
            Rectangle outlineBounds = outline.getBounds();
            transform = g2.getTransform();

            int x = w / 2 - (outlineBounds.width / 2);
            int y = (h / 2 + (outlineBounds.height / 2)) + 20;
            //System.out.println("\tOutline x: " + x);
            //System.out.println("\tOutline y: " + y);
            transform.translate(x, y);
            g2.transform(transform);
            g2.setColor(Color.BLACK);

            listS.add(outline);

            g2.draw(outline);//Shape

            g2.translate(-x, -y);
            //g2.setClip(outline);
            //g2.dispose();
            //g2.setC
      }

      //++++++++++++++++++++++++++++++++++++++++
      private static void createGraphicsFromJP2() {
            Graphics2D g2 = (Graphics2D) JP2.getGraphics();
            g2.create();

            Shape rect = new Rectangle(10, 10, 100, 100);
            g2.setColor(Color.RED);
            g2.draw(rect);
            listS.add(rect);

      }

      //++++++++++++++++++++++++++++++++++++++++
      private void creatingG(Graphics2D g2) {
            g2.create();

      }

      //+++++++++++++++++++++++++++++++++++++++++++++
      private static GradientPaint getCelesteGP(int w, int h, boolean b) {
            if (b == true) {
                  return new GradientPaint(0, 0, Color.WHITE, w, h, Color.CYAN);
            } else {
                  return new GradientPaint(0, 0, Color.WHITE, w, h, Color.CYAN.darker());
            }
      }

      public static void main(String[] args) {
            new FontMetrics_ex();
            new VT();
            /*
            GraphicsEnvironment.getLocalGraphicsEnvironment().
                    getAvailableFontFamilyNames();

            Font[] listF = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
            for (int a = 0; a < listF.length; a++) {
                  System.out.println((a + 1) + ": " + listF[a].getFamily());
            }
             */
      }
}
