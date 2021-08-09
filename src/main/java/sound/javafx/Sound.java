package sound.javafx;


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

      Sound(){
            System.out.println("MAIN");
            Platform.startup(() -> {
                  System.out.println("\tSTARTUP");
                  //Media hit = new Media(Sound.class.getResource("/SOUND.mp3").toString());
                  Media hit = new Media(Sound.class.getResource("/sound/javafx/SOUND.wav").toExternalForm());
                  MediaPlayer mediaPlayer = new MediaPlayer(hit);
                  

                  Timeline tl = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
                        System.out.println("\t\tPLAY");
                        mediaPlayer.play();
                  }));
                  tl.setCycleCount(10);
                  tl.play();
            });
      }

      public static void main(String[] args)  {
            new Sound();
      }
}
