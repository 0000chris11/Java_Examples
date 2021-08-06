package swing.game_ex;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Animation {

	private List<?> frame;
	private int index;
	private long time;
	private long totaltime;
	//-----------------------------------------
	private Animation() {
		frame = new ArrayList<>();
		totaltime = 0;
		start();
	}
	//-----------------------------------------
	synchronized void addScene(Image i, long t) {
		totaltime += t;
		//frame.add(new picFrame(i totaltime));
	}
	
	synchronized void start() {
		time = 0;
		index = 0;
	}
	synchronized void update(long timeP) {
		if(frame.size()>1) {//if there is more than one picture in the list
			time += timeP;
			if(time>=totaltime) {
				time = 0;
				index = 0;
			}
		}
	}
}
	