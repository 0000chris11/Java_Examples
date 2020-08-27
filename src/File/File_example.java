package File;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

public class File_example extends JFrame {

      private Formatter format;
      private File file;
      private Scanner sc;

      JPanel panel = new JPanel();
      JLabel lb_text = new JLabel("Insert Url");
      
      String url = "C:\\C0F\\About Music\\Album Front\\Adult.jpg";
      ImageIcon icon  = new ImageIcon(url);
      //Image img = new Image(icon.getImage());
      JLabel lb_img = new JLabel();
      
      

      public File_example() {
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

            lb_text.setLocation(6, 6);
            lb_text.setSize(100, 42);
            lb_text.setForeground(Color.WHITE);
            panel.add(lb_text);
            //+++++++++++++++++++++++++++++++++++++++++++++++++
            BufferedImage bimage = new BufferedImage(300,300,BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = bimage.createGraphics();
            
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(icon.getImage(), 0, 0, 300, 300, null);
            
            System.out.println("BufferedImage Width: "+ bimage.getWidth()+ "\tHeight: "+ bimage.getHeight());
            
            ImageIcon icon2 = new ImageIcon(bimage);
            //++++++++++++++++++++++++++++++++++++++++++++++++++
            lb_img.setLocation(6, lb_text.getY() + lb_text.getHeight() + 6);
            lb_img.setSize(300, 300);
            lb_img.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            lb_img.setIcon(icon2);
            panel.add(lb_img);

            System.out.println("WELCOME\n");
      }

      public void seeFile(String url) {
            file = new File(url);
            if (file.exists()) {
                  System.out.println(file.getName() + " exists");
            } else {
                  System.out.println("ERROR");
            }
      }

      public void createFile(String url) {
            try {//Use a different url
                  format = new Formatter(url);
                  System.out.println("You created " + format);
            } catch (Exception e) {
                  System.out.println("ERROR");
            }
      }

      public void addRecords(String text) {
            format.format(text);
      }

      public void closeFile() {
            format.close();
      }

      public void openFile(String url) {
            try {
                  sc = new Scanner(new File(url));
            } catch (Exception e) {
            }

            while (sc.hasNext()) {
                  String a = sc.next();
                  System.out.printf(a + " ");
            }

      }
}
