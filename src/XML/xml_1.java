package XML;

import java.io.File;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author C0FII
 */
public class xml_1 {

      Document doc;

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Select 1 or 2");
            String data = sc.nextLine();
            int d = Integer.parseInt(data);
            
            xml_2 xm = new xml_2();
            xm.createDocument(d);
            
            if (d == 1) {
                  xm.fillDocument();
                  xm.setTransform();
            } else if (d == 2) {
                  xm.getDocument();
            }
      }

}
