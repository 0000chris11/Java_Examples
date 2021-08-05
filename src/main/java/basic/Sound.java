package basic;

import java.io.File;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * Does Not Work
 */
class Sound {

      public static void main(String[] args)  {
            System.out.println("MAIN");
            Platform.startup(() -> {
                  System.out.println("\tSTARTUP");
                  //Media hit = new Media(Sound.class.getResource("/SOUND.mp3").toString());
                  Media hit = new Media(new File("C:\\C0F\\Music\\Z Sounds\\SOUND.wav").toURI().toString());
                  MediaPlayer mediaPlayer = new MediaPlayer(hit);
                  

                  Timeline tl = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
                        System.out.println("\t\tPLAY");
                        mediaPlayer.play();
                  }));
                  tl.setCycleCount(10);
                  tl.play();
            });

      }
}
