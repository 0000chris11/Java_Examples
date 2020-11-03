package NB_Window.TEXT;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Christopher
 */
public class KeyText implements KeyListener {

      @Override
      public void keyTyped(KeyEvent arg0) {
      }

      @Override
      public void keyPressed(KeyEvent arg0) {

      }

      @Override
      public void keyReleased(KeyEvent evt) {
            //TextFieldControl tfc = new TextFieldControl();
            //System.out.println("KeyReleased");
            int valor = Integer.parseInt(TextFieldControl.getTf_ex().getText());
            //System.out.println("\t" + TextFieldControl.getTf_ex().getText() + " // IF KeyEvent...");
            if (KeyEvent.VK_DOWN == evt.getKeyCode()) {
                  //System.out.println("\tis Down");
                  if (valor > 0) {
                        //System.out.println("\t\tabove 0");
                        //tfc.setTf_ex(Integer.toString(--valor));
                        TextFieldControl.getTf_ex().setText(Integer.toString(++valor));
                  }
            } else if (KeyEvent.VK_UP == evt.getKeyCode()) {
                  //System.out.println("\tis Up");
                  if (valor < 9) {
                        //System.out.println("\t\tbelow 9");
                        TextFieldControl.getTf_ex().setText(Integer.toString(--valor));
                  }
            }
      }
}
