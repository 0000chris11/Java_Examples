package swing.scanner_file_source;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

public class FileExample extends JFrame {

      private transient Formatter format;
      private transient Scanner sc;

      JPanel panel = new JPanel();
      JLabel lbText = new JLabel("Insert Url");

      String url = "C:\\C0F\\About Music\\Album Front\\Adult.jpg";
      ImageIcon icon = new ImageIcon(url);
      // Image img = new Image(icon.getImage());
      JLabel lbImg = new JLabel();

      FileExample() {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setLocation(10, 10);
            setSize(600, 400);
            setLayout(null);
            setVisible(true);

            panel.setLocation(6, 6);
            panel.setSize(570, 350);
            panel.setLayout(null);
            panel.setBackground(Color.BLACK);
            add(panel);

            lbText.setLocation(6, 6);
            lbText.setSize(100, 42);
            lbText.setForeground(Color.WHITE);
            panel.add(lbText);
            // +++++++++++++++++++++++++++++++++++++++++++++++++
            BufferedImage bimage = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = bimage.createGraphics();

            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(icon.getImage(), 0, 0, 300, 300, null);

            System.out.println("BufferedImage Width: " + bimage.getWidth() + "\tHeight: " + bimage.getHeight());

            ImageIcon icon2 = new ImageIcon(bimage);
            // ++++++++++++++++++++++++++++++++++++++++++++++++++
            lbImg.setLocation(6, lbText.getY() + lbText.getHeight() + 6);
            lbImg.setSize(300, 300);
            lbImg.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            lbImg.setIcon(icon2);
            panel.add(lbImg);

            System.out.println("WELCOME\n");
      }

      void seeFile(String url) {
            File file = new File(url);
            if (file.exists()) {
                  System.out.println(file.getName() + " exists");
            } else {
                  System.out.println("ERROR");
            }
      }

      void createFile(String url) {
            try {// Use a different url
                  format = new Formatter(url);
                  System.out.println("You created " + format);
            } catch (Exception e) {
                  System.out.println("ERROR");
            }
      }

      void addRecords(String text) {
            format.format(text);
      }

      void closeFile() {
            format.close();
      }

      void openFile(String url) {
            try {
                  sc = new Scanner(new File(url));
            } catch (Exception e) {
                  e.printStackTrace();
            }

            while (sc.hasNext()) {
                  String a = sc.next();
                  System.out.println(a + " ");
            }

      }
}
