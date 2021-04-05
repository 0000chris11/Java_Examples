package media;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Set;

import javafx.application.Application;
import javafx.collections.ObservableMap;
import javafx.collections.MapChangeListener.Change;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer.Status;
import javafx.stage.Stage;

public class MediaTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {   
        //TESTING MEDIA
        File file = new File("C:\\C0F\\Music\\Average\\1979.mp3");
        
        Media media = new Media(file.toURI().toString());
        media.getMetadata().addListener((Change<? extends String, ? extends Object> c) -> {
            if(c.wasAdded()){
                String key = c.getKey();
                if(key.equals("raw metadata")){
                    Map<String, ByteBuffer> map = (Map<String,ByteBuffer>) c.getValueAdded();
                    Set<String> set = map.keySet();
                    set.forEach(e -> System.out.println("raw metadata: " + e));
                }else{
                    System.out.println("KEY: " + key + ": " + c.getValueAdded().toString());
                }
                
            }
        });

        MediaPlayer mediaPlayer = new MediaPlayer(media);
        System.out.println("MEDIA PLAYER");

        //LAYOUT
        Button playButton = new Button("PRESS");
        Button statusButton = new Button("Status");
        MediaView mediaView = new MediaView(mediaPlayer);//NOT WORKING

        //LAYOUT LISTENERS
        playButton.setOnAction(e -> mediaPlayer.play());
        statusButton.setOnAction(e -> {
            if(mediaPlayer.getStatus().equals(Status.READY)){
                System.out.println("\tstatus ready");
            }else{
                System.out.println("\tstatus not ready");
            }
        });

        HBox pane = new HBox(10);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.getChildren().addAll(playButton, statusButton, mediaView);
        //SHOW
        stage.setScene(new Scene(pane, 200, 200));
        stage.show();
    }
}
