package sound.javax;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author C0FII
 */
public class SoundMain {

      public static Mixer mixer;
      public static Clip clip1;
      public static Clip clip2;
      public static Clip[] clips = new Clip[]{clip1, clip2};
      public static Mixer.Info[] mixInfo;

      public void addMixerAndDataLine(Mixer.Info[] mi, Clip[] cs, Mixer mx) {
            mi = AudioSystem.getMixerInfo();
            System.out.println("Mixer.Info size: " + mi.length + "\n");
            /*for (int a = 0; a < mi.length; a++) {
                  System.out.println(a + ": " + mi[a].getName() + ": \t" + mi[a].getDescription());
            }*/

            System.out.println("mixInfo 2: " + mi[2].toString());
            mx = AudioSystem.getMixer(mi[2]);

            System.out.println("\nis line supported: "
                    + AudioSystem.isLineSupported(mx.getLineInfo()));
            //+++++++++++++++++++++++++++++++++++++++++++++++
            try {
                  DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
                  if (cs.length == 0) {
                        System.out.println("clips has nothing");
                  } else {
                        System.out.println("clips length: " + cs.length);
                        for (int a = 0; a < cs.length; a++) {
                              System.out.println(a);
                              cs[a] = (Clip) mx.getLine(dataInfo);
                        }
                        System.out.println("clip info (addMixerAndDataLine): " + cs[0].getLineInfo());
                        //mx.
                  }
            }//Line to Clip
            catch (LineUnavailableException ex) {
                  ex.printStackTrace();
            }
      }

      public void addSoundFile(String fileName, Clip c) {
            try {
                  File f = new File(fileName);
                  AudioInputStream audioStream = AudioSystem.getAudioInputStream(f);
                  System.out.println("clip info (addSoundFile): " + c.getLineInfo());
                  c.open(audioStream);
            } catch (MalformedURLException mue) {
                  mue.printStackTrace();
            } catch (UnsupportedAudioFileException uafe) {
                  uafe.printStackTrace();
            } catch (IOException ioe) {
                  ioe.printStackTrace();
            } catch (LineUnavailableException lue) {
                  lue.printStackTrace();
            }
      }

      public void audioFileFormatInfo(AudioFileFormat aff, AudioFormat af) {
            System.out.println("File Format Type: " + aff.getType());
            System.out.println("File Format String: " + aff.toString());
            System.out.println("File lenght: " + aff.getByteLength());
            System.out.println("Frame length: " + aff.getFrameLength());

            System.out.println("Channels: " + af.getChannels());
            System.out.println("Encoding: " + af.getEncoding());
            System.out.println("Frame Rate: " + af.getFrameRate());
            System.out.println("Frame Size: " + af.getFrameSize());
            System.out.println("Sample Rate: " + af.getSampleRate());
            System.out.println("Sample size (bits): " + af.getSampleSizeInBits());
            System.out.println("Big endian: " + af.isBigEndian());
            System.out.println("Audio Format String: " + af.toString());
      }

      public void mp3ToWav(String fileName) {
            try {
                  File f = new File(fileName);
                  AudioFileFormat inputFileFormat = AudioSystem.getAudioFileFormat(f);
                  AudioInputStream ais = AudioSystem.getAudioInputStream(f);
                  AudioFormat audioFormat = ais.getFormat();

                  audioFileFormatInfo(inputFileFormat, audioFormat);

            } catch (UnsupportedAudioFileException ex) {
                  ex.printStackTrace();
            } catch (IOException ex) {
                  ex.printStackTrace();
            }
      }

      public static void main(String[] args) {
            SoundMain m = new SoundMain();
            m.addMixerAndDataLine(mixInfo, clips, mixer);

            m.addSoundFile("C:\\C0F\\Music\\X Music\\Star's Theme.wav", clips[0]);

            //m.mp3ToWav("C:\\C0F\\Music\\14 Freezeman.mp3");
            m.mp3ToWav("C:\\C0F\\Music\\X Music\\Star's Theme.wav");
            //addSoundFile("C:\\C0F\\Music\\44 Special Item 1.mp3", clips[1]);
            //++++++++++++++++++++++++++++++++++++++++++++++
            //System.out.println("\nGetMixer");

            System.out.println("Star");
            /*
            clip1.start();
            do {
                  try {
                        Thread.sleep(1000);
                  } catch (InterruptedException ie) {
                        ie.printStackTrace();
                  }
            } while (clip1.isActive());
             */
      }
}
