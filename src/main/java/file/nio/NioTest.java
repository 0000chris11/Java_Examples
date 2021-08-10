package file.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

class NioTest {

    private LinkOption[] linkOptions = new LinkOption[] { LinkOption.NOFOLLOW_LINKS };

    NioTest() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("CHOOSE: ");
        System.out.println("exist - create directory");
        String nextLine = sc.nextLine();
        switch (nextLine) {
            case "exist":
                System.out.println("exist CHOOSE PATH: ");
                Path path = Paths.get(sc.nextLine());

                boolean exist = Files.exists(path, linkOptions);
                System.out.println("\tFile exist: " + exist);
                break;
            case "create directory":
                System.out.println("create directory CHOOSE PATH: ");
                Path pathDirectory = Paths.get(sc.nextLine());

                Path newPath = Files.createDirectory(pathDirectory);
                System.out.println("\tNew Path Created: " + newPath.toString());
                break;
            case "copy":
                System.out.println("copy CHOOSE PATH FROM: ");
                Path pathFrom = Paths.get(sc.nextLine());
                System.out.println("copy CHOOSE PATH TO: ");
                Path pathTo = Paths.get(sc.nextLine());

                Path newCopyPath = Files.copy(pathFrom, pathTo);
                System.out.println("\tNew Path to Copy: " + newCopyPath);
                break;
            case "move":
                System.out.println("move CHOOSE PATH FROM: ");
                pathFrom = Paths.get(sc.nextLine());
                System.out.println("move CHOOSE PATH TO: ");
                pathTo = Paths.get(sc.nextLine());
                Path movedPath = Files.move(pathFrom, pathTo, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("\tFile move to: " + movedPath);
                break;
            case "delete":
                System.out.println("delete CHOOSE PATH: ");
                path = Paths.get(sc.nextLine());
                Files.delete(path);
                break;

            case "read":
                System.out.println("read CHOOSE PATH: ");
                Path pathRead = Paths.get(sc.nextLine());
                byte[] bytes = Files.readAllBytes(pathRead);

                StringBuilder sb = new StringBuilder(200);
                for (byte x : bytes) {
                    sb.append((char) x);
                }
                System.out.println("Read: " + sb.toString());
                break;
            case "write":
                System.out.println("write CHOOSE PATH: ");
                Path pathWrite = Paths.get(sc.nextLine());
                String text = "Ending of the Year";
                Files.write(pathWrite, text.getBytes());
                break;
            default:
                break;
        }

        sc.close();
    }

    public static void main(String[] args) throws IOException {
        new NioTest();
    }
}
