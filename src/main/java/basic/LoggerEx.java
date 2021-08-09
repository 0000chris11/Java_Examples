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
class LoggerEx {
      
      static Logger logger = Logger.getLogger(LoggerEx.class.getName());
      
      LoggerEx(){
            System.out.println("to print...");
            logger.setLevel(Level.OFF);
            logger.log(Level.SEVERE, "\tI DID IT...");
            
      }
      
      public static void main(String[] args){
            new LoggerEx();
      }
}
