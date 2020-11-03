package Array_List;

import java.util.*;

public class Stack_e {

      public static void main(String[] args) {
            Stack<String> st = new Stack<String>();

            st.push("first");
            System.out.println(st);
            st.push("second");
            System.out.println(st);
            st.push("third");
            System.out.println(st);
            st.pop();
            System.out.println(st);
            st.pop();
            System.out.println(st);
            st.pop();
            System.out.println(st);
      }
}
