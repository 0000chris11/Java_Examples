
package Constructor;

/**
 *
 * @author Christopher
 */
public class Data {
      
      static String Song_S = "Static-Song";
      static String Artist_S = "Static-Artist";
      static String Album_S = "Static-Album";
      static String Genre_S = "Static-Genre";
      static int Year_S = 2000;
      
      String Song = "Song";
      String Artist = "Artist";
      String Album = "Album";
      String Genre = "Genre";
      int Year = 1996;

      
      Data(){
            System.out.println(CC.CYAN + "Data Constructor" + CC.RESET);
      }
      Data(String from){
            System.out.println(CC.CYAN + "Data Constructor ------- FROM: \"" + from + "\""
            + CC.RESET);
      }
}
