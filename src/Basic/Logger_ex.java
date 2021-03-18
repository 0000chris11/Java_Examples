/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author C0FII
 */
public class Logger_ex {
      
      static Logger logger = Logger.getLogger(Logger_ex.class.getName());
      
      public Logger_ex(){
            System.out.println("to print...");
            logger.setLevel(Level.OFF);
            logger.log(Level.SEVERE, "\tI DID IT...");
            
      }
      
      public static void main(String[] args){
            new Logger_ex();
      }
}
