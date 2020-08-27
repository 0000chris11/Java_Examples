package Advanced;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Writer_Examp {

      public static void main(String[] args) {
            try {
                  FileOutputStream fops = new FileOutputStream("UTF-8");
                  Writer unicodeFileWriter2 = new OutputStreamWriter(fops);
                  try {
                        unicodeFileWriter2.write("ありがとございます");
                  } catch (IOException ex) {
                        Logger.getLogger(Writer_Examp.class.getName()).log(Level.SEVERE, null, ex);
                  }
            } catch (FileNotFoundException ex) {
                  Logger.getLogger(Writer_Examp.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
}
