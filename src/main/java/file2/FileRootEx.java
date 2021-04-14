package file2;

import java.io.File;
import java.io.IOException;

public class FileRootEx {

    public static void main(String[] args) throws IOException {
        //CREATE FILES OR DIRECTORYS ON THE ROOT OF THE PROJECT (BEFORE SRC)
        File f1 = new File("deleteMe.txt");
        if(!f1.exists()){
            System.out.println(f1.createNewFile());
        }

        File f2 = new File("Delete Folder");
        if(!f2.exists()){
            System.out.println(f2.mkdir());
        }

        File f3 = new File(f2, "deleteMe2.txt");
        if(!f3.exists()){
            System.out.println(f3.createNewFile());
        }
    }
}
