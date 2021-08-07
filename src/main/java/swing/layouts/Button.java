/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.layouts;

import javax.swing.BoxLayout;
import javax.swing.JButton;

/**
 *
 * @author C0FII
 */
class Button extends JButton {

      Button(String layout) {
            if(layout == null){
                  setLayout(null);
            }else if(layout.equalsIgnoreCase("miglayout")){
                  //setLayout(new MigLayout());
            } else if(layout.equalsIgnoreCase("boxlayout")){
                  setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            }
            //setLocation(4,4);
            setSize(100, 40);
      }
}
