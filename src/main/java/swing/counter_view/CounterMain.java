package swing.counter_view;

/**
 * Old attemp to create a window with only counter function
 * @author C0FII
 */
public class CounterMain {
	
	
	public static void main(String args[]) {
		CounterView cv = new CounterView();
		new CounterController(cv);
		
	}
}
