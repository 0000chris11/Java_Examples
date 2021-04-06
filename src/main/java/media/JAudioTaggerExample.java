package media;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.flac.FlacFileReader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;

public class JAudioTaggerExample {
    public static void main(String[] args) {
        File file = new File("C:\\C0F\\Music\\Sailor Moon\\01 - Prologue.flac");
        if (file.getPath().endsWith(".mp3")) {
            try {
                MP3File mp3File = (MP3File) AudioFileIO.read(file);
                MP3AudioHeader mp3AudioHeader = mp3File.getMP3AudioHeader();

                System.out.println("Audio Bit Rate: " + mp3AudioHeader.getBitRate());
                System.out.println("Sample Rate: " + mp3AudioHeader.getSampleRateAsNumber());
            } catch (CannotReadException | IOException | TagException | ReadOnlyFileException
                    | InvalidAudioFrameException e) {
                e.printStackTrace();
            }
        } else if (file.getPath().endsWith(".flac")) {
            FlacFileReader flacFileReader = new FlacFileReader();
            try {
                AudioFile audioFile = flacFileReader.read(file);
                AudioHeader audioHeader = audioFile.getAudioHeader();

                System.out.println("Audio Bit Rate: " + audioHeader.getBitRate());
                System.out.println("Sample Rate: " + audioHeader.getSampleRateAsNumber());
            } catch (CannotReadException | IOException | TagException | ReadOnlyFileException
                    | InvalidAudioFrameException e) {
                e.printStackTrace();
            }
        }
    }
}
