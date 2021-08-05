package array_of_interfaces;

/**
 *
 * @author C0FII
 */
public class ArrayMethods {

      MyClass myClass = new MyClass();

      public interface Select2 {
            void hold2();
      }

      // --------------------------------------------
      // HOLDING TWO INSTANCE OF AN INTERFACE WITH DIFFERENT ACTION
      private SelectInterface[] selectInterfaceArray = new SelectInterface[] { myClass::selectInt,
                  myClass::selectString };

      // METHODS------------------------------------
      public static void choose(int index) {
            // SL[index].hold();
      }

      // GETTER & SETTERS----------------------------
      public SelectInterface[] getSelect() {
            return selectInterfaceArray;
      }

}
