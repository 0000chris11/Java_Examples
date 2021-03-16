/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import com.cofii2.methods.MComp;
import com.cofii2.methods.MImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

/**
 *
 * @author C0FII
 */
public class ImageReizeTest {

      private JFrame JF = new JFrame();
      private JPanel JP = new JPanel();
      private JPanel JP2 = new JPanel();
      
      private JLabel lb = new JLabel();
      private final Icon ii = new ImageIcon("C:\\C0F\\Manga - Comic\\Hajime no Ippo\\Hajime no Ippo 83.jpg");
      
      private JButton btn_change = new JButton("Change Size");

      private ImageReizeTest() {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.getContentPane().setLayout(new BorderLayout());

            JF.getContentPane().add(JP, BorderLayout.CENTER);
            JF.getContentPane().add(JP2, BorderLayout.SOUTH);
            
            JP.setPreferredSize(new Dimension(ii.getIconWidth(), ii.getIconHeight()));
            JP.setLayout(new FlowLayout());
            JP.add(lb);
            lb.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.BLUE, Color.DARK_GRAY));
            lb.setPreferredSize(new Dimension(100, 100));
            //++++++++++++++++++++++++++++++++++
            MImage.setOption(MImage.DRAW_CIRCLES);
            MImage.setColors(new Color[]{Color.RED, Color.BLUE});
            Icon ii2 = MImage.resizeIcon(null, 20, 27);
            lb.setIcon(ii2);
            //++++++++++++++++++++++++++++++++++
            
            JP2.setBackground(Color.BLACK);
            JP2.setMaximumSize(new Dimension(Short.MAX_VALUE, 28));
            JP2.setLayout(new BoxLayout(JP2, BoxLayout.X_AXIS));
            JP2.add(btn_change, 0);
            btn_change.setMaximumSize(new Dimension(180, 28));
            btn_change.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        Dimension scaled = MImage.getScaledDownHeight_AR(
                                new Dimension(ii.getIconWidth(), ii.getIconHeight()), 250);
                        lb.setPreferredSize(scaled);
                        lb.setIcon(MImage.resizeIcon((ImageIcon) ii, scaled));
                        
                  }
                  
            });
            
      }

      


      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        ImageReizeTest tt = new ImageReizeTest();
                        tt.JF.setSize(new Dimension(300, 200));
                        MComp.setFrameToCenterOfScreen(tt.JF);
                        tt.JF.setVisible(true);
                  }

            });
      }
}
