package file2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InputStreamTest extends Application {

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
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        /*
        String urlRead = "resources/rocket.gif";
        readingInputStreamBytes(urlRead);
        readingInputStreamByteArray(urlRead);
        readingBufferedInputStream(urlRead);

        String urlWrite = "resources/WriteOnMe.txt";
        String text = "Writing on You!";
        writing(urlWrite, text);
        */

        readAndWrite("resources/rocket.gif", "resources/rocketCopy.gif");

        stage.setScene(new Scene(new VBox(), 200, 200));
        stage.show();

    }
}
