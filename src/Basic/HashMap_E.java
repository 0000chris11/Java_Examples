
package Basic;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

public class HashMap_E extends JFrame{
      HashMap<Component, Integer> hm;
      JPanel panel = new JPanel();
      JButton btn_1 = new JButton();
      JButton btn_2 = new JButton();
      
      ButtonA ba = new ButtonA();
      
      public HashMap_E(){
            String a = "Dan no";
            String b = "Dan Stop!";
            String c = "Doop";
            Integer a1 = 566;
            Integer a2 = 22;
            Integer a3 = 4;
            System.out.println("hashCode for a: "+ a.hashCode());
            System.out.println("hashCode for b: "+ b.hashCode());
            System.out.println("hashCode for c: "+ c.hashCode()+"\n");
            System.out.println("hashCode for a1: "+ a1.hashCode());
            System.out.println("hashCode for a2: "+ a2.hashCode());
            System.out.println("hashCode for a3: "+ a3.hashCode());
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setSize(500,500);
            setLayout(null);
            
            panel.setLayout(null);
            panel.setLocation(4, 4);
            panel.setSize(490, 490);
            panel.setBackground(Color.BLACK);
            add(panel);
            
            btn_1.setLocation(6, 6);
            btn_1.setSize(40, 24);
            add(btn_1);
            btn_1.addActionListener(ba);
            
            btn_2.setLocation(50, 6);
            btn_2.setSize(40, 24);
            add(btn_2);
            btn_2.addActionListener(ba);
            //++++++++++++++++++++++++++++++++++++++++++++++++++++
            hm = new HashMap<Component, Integer>();
            hm.put(btn_1, 1);
            hm.put(btn_2, 2);
            //++++++++++++++++++++++++++++++++++++
            System.out.println("get btn_1: "+ hm.get(btn_1));
      }
      
      public class ButtonA implements ActionListener {
            public void actionPerformed(ActionEvent e){
                  
            }
      }
      public static void main(String[] args){
            HashMap_E hme = new HashMap_E();
            hme.setVisible(true);
      }
}
