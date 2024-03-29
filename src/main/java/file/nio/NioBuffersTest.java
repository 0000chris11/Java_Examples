package file.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

class NioBuffersTest {

    private static final String URL = "resources/NioTest.txt";

    private void read() {
        try (RandomAccessFile file = new RandomAccessFile(URL, "rw")) {
            FileChannel channel = file.getChannel();

            long size = channel.size();
            ByteBuffer buffer = ByteBuffer.allocate((int) size);

            int bytesRead = channel.read(buffer);
            StringBuilder sb = new StringBuilder();
            while (bytesRead != -1) {
                System.out.println("bytesRead: " + bytesRead);

                buffer.flip();
                while (buffer.hasRemaining()) {
                    sb.append((char) buffer.get());
                }
                buffer.clear();
                bytesRead = channel.read(buffer);
            }

            System.out.println(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void write() {
        try (RandomAccessFile file = new RandomAccessFile(URL, "rw")) {
            FileChannel channel = file.getChannel();

            String text = "TEXT FROM FILE CHANNEL";
            ByteBuffer buffer = ByteBuffer.allocate(128);

            buffer.clear();
            buffer.put(text.getBytes());

            buffer.flip();
            while (buffer.hasRemaining()) {
                channel.write(buffer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    NioBuffersTest() {
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        switch (choice) {
            case "write":
                write();
                break;
            case "read":
                read();
                break;
            default:
                break;
        }
        sc.close();
    }

    public static void main(String[] args) {
        new NioBuffersTest();
    }
}