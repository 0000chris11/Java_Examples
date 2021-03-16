package XML;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author Christopher
 */
public class xmlC {

      private static Document doc;

      public void createDocument(int n) {
            System.out.println("createDocument");
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            try {
                  DocumentBuilder DB = DBF.newDocumentBuilder();
                  if (n == 1) {
                        DOMImplementation DOMI = DB.getDOMImplementation();
                        doc = DOMI.createDocument(null, "DocumnetXML", null);
                        doc.setXmlVersion("1.0");
                  } else if (n == 2) {
                        doc = DB.parse(new File("C:\\C0F\\NetBeans Worl-Space\\Examples\\Documnet 2.xml"));
                  }
            } catch (ParserConfigurationException | SAXException | IOException ex) {
                  ex.printStackTrace();
            }
      }

      //++++++++++++++++++++++++++++++++++++++++
      public void fillDocument() {
            System.out.println("fillDocument");
            Element name1 = doc.createElement("Name");
            Element name2 = doc.createElement("Name");
            name1.setAttribute("Id", "1");
            name2.setAttribute("Id", "2");
            name1.appendChild(doc.createTextNode("Glass no shogen"));
            name2.appendChild(doc.createTextNode("Guys like you"));

            doc.getDocumentElement().appendChild(name1);
            doc.getDocumentElement().appendChild(name2);

            Element[] elList = fiilDocumentConfig("Keiko Kimura", "Style", "J-POP");
            name1.appendChild(elList[0]);
            name1.appendChild(elList[1]);
            name1.appendChild(elList[2]);
            elList = fiilDocumentConfig("Stacy Lattisaw", "Sneakin' out", "R&B");
            name2.appendChild(elList[0]);
            name2.appendChild(elList[1]);
            name2.appendChild(elList[2]);

      }

      public Element[] fiilDocumentConfig(String artText, String albText, String genText) {
            Element artist = doc.createElement("Artist");
            artist.appendChild(doc.createTextNode(artText));

            Element album = doc.createElement("Album");
            album.appendChild(doc.createTextNode(albText));

            Element genre = doc.createElement("Genre");
            genre.appendChild(doc.createTextNode(genText));

            return new Element[]{artist, album, genre};
      }

      public void getDocument() {
            System.out.println("getDocument");
            NodeList nl = doc.getElementsByTagName("Name");
            System.out.println("\tNodeList length containing \"Name\": " + nl.getLength());
            for (int a = 0; a < nl.getLength(); a++) {
                  Node n = nl.item(a);
                  System.out.println("\t" + a + " :" + n.getNodeName());
                  if (n.getNodeType() == Node.ELEMENT_NODE) {
                        Element en = (Element) n;
                        String id = en.getAttribute("Id");
                        NodeList subC = en.getChildNodes();
                        for(int b = 0; b < subC.getLength(); b++){
                              Node ns = subC.item(b);
                              if(ns.getNodeType() == Node.ELEMENT_NODE){
                                    Element ens = (Element) ns;
                                    System.out.println("\t\t" + en.getNodeName() + " ("+ id + ") -> " + ens.getNodeName());
                              }
                        }
                  }
            }
      }

      //++++++++++++++++++++++++++++++++++++++++
      public void setTransform() {
            System.out.println("setTransform");
            Source source = new DOMSource(doc);
            Result res = new StreamResult(new File("Documnet 2.xml"));
            try {
                  Transformer transf = TransformerFactory.newInstance().newTransformer();
                  transf.transform(source, res);

            } catch (TransformerConfigurationException ex) {
                  ex.printStackTrace();
            } catch (TransformerException ex) {
                  ex.printStackTrace();
            }

      }
}

