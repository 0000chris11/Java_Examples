package file.sound.flac;

import java.io.File;
import java.io.IOException;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.flac.FlacFileReader;
import org.jaudiotagger.tag.TagException;

public class FlacReaderTest {

    private static final String FILE_URL = "C:\\C0F\\Music\\Sailor Moon\\03 - Kawaii Takurami.flac";

    public static void main(String[] args) {
        //IS THIS CLASS UNFINISHED?
        /*
        FLACEncoder flacEncoder = new FLACEncoder();
        
        FlacAudioFileReader flacAudioFileReader = new FlacAudioFileReader();
        try {
            FlacAudioFormat audioFileFormat = (AudioFileFormat) flacAudioFileReader.getAudioFileFormat(new File(FILE_URL));
        } catch (UnsupportedAudioFileException | IOException e1) {
            e1.printStackTrace();
        }
        */
        //ONLY FOR READING AND TO GET OI INFOO
        FlacFileReader flacFileReader = new FlacFileReader();
        AudioFile audioFile;
        try {
            audioFile = flacFileReader.read(new File(FILE_URL));
            System.out.println(audioFile.displayStructureAsPlainText());
        } catch (CannotReadException | IOException | TagException | ReadOnlyFileException
                | InvalidAudioFrameException e) {
            
            e.printStackTrace();
        }
        
        
    }
}