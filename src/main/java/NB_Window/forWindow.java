
package NB_Window;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 *
 * @author Christopher
 */
public interface forWindow {
      
      abstract void frameConfig();
      
      JFrame JF = new JFrame();
      JPanel JP = new JPanel();
      
      JMenuBar JB = new JMenuBar();
}
