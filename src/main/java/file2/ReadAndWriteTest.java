package file2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class ReadAndWriteTest extends Application {

    private static final int BUFFER_SIZE = 4 * 1024;

    private void readingInputStreamBytes(String url){
        long init = System.currentTimeMillis();
        try (InputStream is = new FileInputStream(url)){
            int i = is.read();
            while (i != -1) {
                i = is.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("\ntime (readingInputStreamBytes): " + (end - init));
    }
    private void readingInputStreamByteArray(String url) {
        long init = System.currentTimeMillis();
        try (InputStream is = new FileInputStream(url)){
            byte[] array = new byte[1024];
            int i = is.read(array);
            while (i != -1) {
                i = is.read(array);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("\ntime (readingInputStreamByteArray): " + (end - init));
    }
    private void readingBufferedInputStream(String url){
        long init = System.currentTimeMillis();
        int bufferSize = 16 * 1024;//16kbs
        try (InputStream is = new BufferedInputStream(new FileInputStream(url), bufferSize)){
            byte[] array = new byte[1024];
            int i = is.read(array);
            while (i != -1) {
                i = is.read(array);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("\ntime (readingBufferedInputStream): " + (end - init));
    }
    //-----------------------------------------------------------
    private void writing(String url, String text){
        long init = System.currentTimeMillis();
        try (OutputStream os = new FileOutputStream(url)) {
            os.write(text.getBytes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        long end = System.currentTimeMillis();
        System.out.println("Time (writing): " + (end - init));
    }
    
    private void readAndWrite(String urlFrom, String urlTo){
        
        long init = System.currentTimeMillis(); 

        InputStream is = null;
        byte[] buffer = new byte[1024];//1kb
        try (OutputStream os = new FileOutputStream(urlTo)) {
            is = new FileInputStream(urlFrom);

            int byteRead;
            while((byteRead = is.read(buffer)) != -1){
                os.write(buffer, 0, byteRead);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis(); 
        System.out.println("\nTime (readAndWrite): " + (end - init));
    }
    //-----------------------------------------------------------
    private void reader(String url){
        try (Reader r = new FileReader(url)) {
            int data = r.read();
            System.out.println((char) data);
            while(data != -1){
                data = r.read();
                System.out.println((char) data);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void readerBuffer(String url){
        try (Reader r = new BufferedReader(new FileReader(url), BUFFER_SIZE)) {
            int data = r.read();
            
            System.out.println((char) data);
            while(data != -1){
                data = r.read();
                System.out.println((char) data);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void writer(String url, String text, boolean concat){
        try (Writer w = new FileWriter(url, concat)) {
            w.write(text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void writerBuffer(String url, String text, boolean concat){
        try (Writer w = new BufferedWriter(new FileWriter(url, concat), BUFFER_SIZE)) {
            w.write(text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //-----------------------------------------------------------
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String url = "resources/WriteOnMe.txt";
        String text = "tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt";
        /*
        String urlRead = "resources/rocket.gif";
        readingInputStreamBytes(urlRead);
        readingInputStreamByteArray(urlRead);
        readingBufferedInputStream(urlRead);

        writing(urlWrite, text);
        readAndWrite("resources/rocket.gif", "resources/rocketCopy.gif");
        reader(urlWrite);
        writer(urlWrite, " added text through Writer", true);
        readerBuffer(url);
        */
        
        writerBuffer(url, text, true);

        stage.setScene(new Scene(new VBox(), 200, 200));
        stage.show();

    }
}
