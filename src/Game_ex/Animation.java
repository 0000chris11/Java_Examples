package Game_ex;

import java.awt.Image;
import java.util.ArrayList;

public class Animation {
	private ArrayList frame;
	private int index;
	private long time;
	private long totaltime;
	
	private Animation() {
		frame = new ArrayList();
		totaltime = 0;
		start();
	}
	public synchronized void addScene(Image i, long t) {
		totaltime += t;
		//frame.add(new picFrame(i totaltime));
	}
	
	public synchronized void start() {
		time = 0;
		index = 0;
	}
	public synchronized void update(long timeP) {
		if(frame.size()>1) {//if there is more than one picture in the list
			time += timeP;
			if(time>=totaltime) {
				time = 0;
				index = 0;
			}
		}
	}
}
	