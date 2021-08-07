package Array_Lisr_for_Methods;

/**
 *
 * @author C0FII
 */
public class Array_Methods {

      MyClass MC = new MyClass();

      public interface Select2 {

            void hold2();
      }

      private Select[] SL3 = new Select[]{
              new Select() {
            public void hold() {
                  MC.selectInt();
            }
      }, new Select(){
            public void hold(){
                  MC.selectString();
            }
      }};
      
      public Select[] getSelect(){
            return SL3;
      }

      public static void choose(int index) {
            //SL[index].hold();
      }

      private void unusedMethod(){
            Select[] SL = new Select[2];
            SL[0] = new Select() {
                  public void hold() {
                        choose(3);
                  }
            };
            //++++++++++++++++++
            Select2[] SL2 = new Select2[2];
            SL2[0] = new Select2() {
                  public void hold2() {
                        MC.selectString();
                  }
            };
      }

      
}
