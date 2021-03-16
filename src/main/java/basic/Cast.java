
package basic;

//import Java.lang.Integer;

public class Cast {
      public static void main(String[] args){
            
            double dob = 10.489;
            int in = (int) dob;
            
            System.out.println("double to int:  "+ in);
            
            Integer ger0 = new Integer(300);
            Integer ger = 400;
            
            int in2 = ger.intValue();
            int in3 = ger0.intValue();
            
            System.out.println("integer to int:  "+ in2);
            System.out.println("integer to int:  "+ in3);
            
            String val = "47";
            int in4 = Integer.parseInt(val);
            
            System.out.println("String to int:  "+ in4);
      }
}
