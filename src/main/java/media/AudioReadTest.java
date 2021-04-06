package media;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioFileFormat.Type;

import org.jflac.sound.spi.FlacAudioFileReader;
import org.jflac.sound.spi.RingedAudioInputStream;

public class AudioReadTest {

    private void reading(File file) {
        int totalFramesRead = 0;

        AudioInputStream audioInputStream;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(file);

            int bytesPerFrame = audioInputStream.getFormat().getFrameSize();
            if (bytesPerFrame == AudioSystem.NOT_SPECIFIED) {
                // some audio formats may have unspecified frame size
                // in that case we may read any amount of bytes
                bytesPerFrame = 1;
            }

            // Set an arbitrary buffer size of 1024 frames.
            int numBytes = 1024 * bytesPerFrame;
            byte[] audioBytes = new byte[numBytes];

            try {
                int numBytesRead = 0;
                int numFramesRead = 0;
                // Try to read numBytes bytes from the file.
                while ((numBytesRead = audioInputStream.read(audioBytes)) != -1) {
                    // Calculate the number of frames actually read.
                    numFramesRead = numBytesRead / bytesPerFrame;
                    totalFramesRead += numFramesRead;

                }
                System.out.println("numFramesRead: " + numFramesRead);
                System.out.println("totalFramesRead: " + totalFramesRead);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }

    }

    private void writing(File file) {
        AudioFileFormat.Type[] types = null;
        if (file != null) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                types = AudioSystem.getAudioFileTypes(audioInputStream);

            } catch (UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            }
        } else {
            // LISTING AUDIO FILE TYPES SUPPORTED
            types = AudioSystem.getAudioFileTypes();
        }
        System.out.println("Extension supported: ");
        int count = 1;
        for (AudioFileFormat.Type x : types) {
            System.out.println("\t" + count++ + ": " + x.getExtension());
        }
    }

    private void convertingFlacAttemp(File file, File outFile){
        FlacAudioFileReader flacAudioFileReader = new FlacAudioFileReader();
        try {
            //UnsupportedAudioFileException: Could not find Stream Sync
            AudioInputStream audioInputStream = flacAudioFileReader.getAudioInputStream(file);
            AudioSystem.write(audioInputStream, Type.WAVE, outFile);
            
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }
    // --------------------------------------------------------

    public static void main(String[] args) {
        AudioReadTest audioReadTest = new AudioReadTest();
        System.out.println("READING");
        audioReadTest.reading(new File("C:/C0F/Music/Sailor Moon/07 - Eyecatch.flac"));

        System.out.println("\nWRITING");
        File file = new File("C:/C0F/Music/Sailor Moon/Converted/02 - Atashi Datte Futsuu no Onna no Ko - 1-2-3-7 OF 7.wav");
        File outFile = new File("C:/C0F/newConvertion.wav");
        audioReadTest.convertingFlacAttemp(file, outFile);
    }
}
