package ClassExamples;
import javax.swing.JFrame;

public class WindowM2 {
	public static void main(String[] args) {
		WindowM1 wm1 = new WindowM1();
		wm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wm1.setSize(275,180);
		wm1.setVisible(true);
	}
}
