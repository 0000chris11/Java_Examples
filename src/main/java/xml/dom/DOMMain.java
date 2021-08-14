package xml.dom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.xml.XMLConstants;
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

import com.cofii2.xml.ResourceXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

class DOMMain {

    private void read(DocumentBuilder docBuilder, File file) {
        try {
            Document doc = docBuilder.parse(file);

            String rootName = doc.getDocumentElement().getNodeName();
            System.out.println("rootName: " + rootName);
            NodeList nodeList = doc.getElementsByTagName("Game");
            for (int a = 0; a < nodeList.getLength(); a++) {
                Node node = nodeList.item(a);
                System.out.println("\tNode: " + node.getNodeName() + " (" + (a + 1) + ")");
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String attribute = element.getAttribute("id");
                    System.out.println("\t\tAttribute id: " + attribute);
                    String nameValue = element.getElementsByTagName("name").item(0).getTextContent();
                    System.out.println("\t\telement name: " + nameValue);
                    String genreValue = element.getElementsByTagName("genre").item(0).getTextContent();
                    System.out.println("\t\telement genre: " + genreValue);

                }
            }
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private void write(DocumentBuilder docBuilder) {
        Document doc = docBuilder.newDocument();

        Element root = doc.createElement("animes");
        doc.appendChild(root);
        // ------------------------------------
        Element anime1 = doc.createElement("anime");
        root.appendChild(anime1);
        Element anime2 = doc.createElement("anime");
        root.appendChild(anime2);
        Element anime3 = doc.createElement("anime");
        root.appendChild(anime3);
        // --------------------------------------
        transform(doc, "animes");
    }

    private void update(DocumentBuilder docBuilder, File file){
        try {
            Document doc = docBuilder.parse(file);
            Element root = doc.getDocumentElement();

            Element newGame = doc.createElement("Game");
            newGame.setAttribute("id", "4");
            root.appendChild(newGame);

            transform(doc, "games");
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private void transform(Document doc, String fileName){
        FileWriter writer = null;
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            Source source = new DOMSource(doc);
            
            String path = DOMMain.class.getResource("/").getPath() + "/xml/dom/" + fileName + ".xml";
            path = path.replace("/target/classes", "/src/main/resources");
            File file = new File(path);
            writer = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(writer);
            Result result = new StreamResult(printWriter);
            
            transformer.transform(source, result);

            System.out.println("xml file create at: " + path);
        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Document updateTest(Document doc){
        Element root = doc.getDocumentElement();
        Element game4 = (Element) root.getElementsByTagName("Game").item(3);
        
        Element name = doc.createElement("name");
        name.appendChild(doc.createTextNode("Crash Bandicoot"));
        Element genre = doc.createElement("genre");
        genre.appendChild(doc.createTextNode("3D-Platform"));

        game4.appendChild(name);
        game4.appendChild(genre);

        return doc;
    }

    DOMMain(String[] args) {
        try {
            File file = new File(DOMMain.class.getResource("/xml/dom/test.xml").getFile());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            dbFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();

            //Scanner sc = new Scanner(System.in);
            String option = args[0];
            if (option.equals("read")) {
                read(docBuilder, file);
            } else if (option.equals("write")) {
                write(docBuilder);
            } else if(option.equals("update")){
                update(docBuilder, file);
            } else if(option.equals("testNewClass")){
                System.out.println("testNewClass OPTION");
                new ResourceXML("/xml/dom/games.xml", ResourceXML.UPDATE_XML, this::updateTest);
            }

            //sc.close();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DOMMain(args);
    }
}
