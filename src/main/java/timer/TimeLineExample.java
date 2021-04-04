package timer;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class TimeLineExample {
    public static void main(String[] args) {
        //DOES NOT WORK
        final int[] count = new int[]{1};
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), e -> System.out.println(count[0]++));
        Timeline timeline = new Timeline(keyFrame);

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
