package file2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

class NioTest {

    private LinkOption[] linkOptions = new LinkOption[]{ LinkOption.NOFOLLOW_LINKS };

    NioTest() throws IOException {
        /*
        // EXIST------------------------------------------------------
        Path path = Paths.get("resources/test");

        boolean exist = Files.exists(path, linkOptions);
        System.out.println("File exist: " + exist);
        // CREATE DIRECTORY-----------------------------------------------
        Path pathDirectory = Paths.get("resources/newFolder/");

        Path newPath = Files.createDirectory(pathDirectory);
        System.out.println("New Path Created: " + newPath.toString());
        // COPY-----------------------------------------------
        Path pathFrom = Paths.get("resources/WriteOnMe.txt");
        Path pathTo = Paths.get("resources/WriteOnMeCopy.txt");

        Path newCopyPath = Files.copy(pathFrom, pathTo);
        System.out.println("New Path to Copy: " + newCopyPath);
        // MOVE-----------------------------------------------
        Path pathFrom = Paths.get("resources/tests.txt");
        Path pathTo = Paths.get("resources/FolderReplace/tests.txt");
        Path movedPath = Files.move(pathFrom, pathTo, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File move to: " + movedPath);
        // DELETE-----------------------------------------------
        Path path = Paths.get("resources/delete.txt");
        Files.delete(path);
        // READ--------------------------------------------------
        Path pathRead = Paths.get("resources/TextToBeRead.txt");
        byte[] bytes = Files.readAllBytes(pathRead);

        StringBuilder sb = new StringBuilder(200);
        for(byte x : bytes){
            sb.append((char) x);
        }
        System.out.println("Read: " + sb.toString());
        */
        Path pathWrite = Paths.get("resources/TextToWriteOn.txt");
        String text = "Ending of the Year";
        Files.write(pathWrite, text.getBytes());
    }

    public static void main(String[] args) throws IOException {
        new NioTest();
    }
}
