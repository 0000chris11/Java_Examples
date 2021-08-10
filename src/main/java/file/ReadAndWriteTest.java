package file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

class ReadAndWriteTest {

    private static final int BUFFER_SIZE = 4 * 1024;

    private void readingInputStreamBytesTimeTest(String url) {
        long init = System.currentTimeMillis();

        try (InputStream is = new FileInputStream(url)) {
            int i = is.read();
            while (i != -1) {
                i = is.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("\ntime (readingInputStreamBytes): " + (end - init));
    }

    private void readingInputStreamByteArrayTimeTest(String url) {
        long init = System.currentTimeMillis();
        try (InputStream is = new FileInputStream(url)) {
            byte[] array = new byte[1024];
            int i = is.read(array);
            while (i != -1) {
                i = is.read(array);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("\ntime (readingInputStreamByteArray): " + (end - init));
    }

    private void readingBufferedInputStreamTimeTest(String url) {
        long init = System.currentTimeMillis();

        int bufferSize = 16 * 1024;// 16kbs
        try (InputStream is = new BufferedInputStream(new FileInputStream(url), bufferSize)) {
            byte[] array = new byte[1024];
            int i = is.read(array);
            while (i != -1) {
                i = is.read(array);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("\ntime (readingBufferedInputStream): " + (end - init));
    }

    // -----------------------------------------------------------
    private void writingOutputTimeTest(String url, String text) {
        long init = System.currentTimeMillis();
        try (OutputStream os = new FileOutputStream(url)) {
            os.write(text.getBytes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        long end = System.currentTimeMillis();
        System.out.println("Time (writing): " + (end - init));
    }

    private void readAndWriteTimeTest(String urlFrom, String urlTo) {
        long init = System.currentTimeMillis();

        InputStream is = null;
        byte[] buffer = new byte[1024];// 1kb
        try (OutputStream os = new FileOutputStream(urlTo)) {
            is = new FileInputStream(urlFrom);

            int byteRead;
            while ((byteRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, byteRead);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("\nTime (readAndWrite): " + (end - init));
    }

    // -----------------------------------------------------------
    private void fileReaderPrint(String url) {
        try (Reader r = new FileReader(url)) {
            int data = r.read();
            System.out.println((char) data);
            while (data != -1) {
                data = r.read();
                System.out.println((char) data);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void bufferReaderPrint(String url) {
        try (Reader r = new BufferedReader(new FileReader(url), BUFFER_SIZE)) {
            int data = r.read();

            System.out.println((char) data);
            while (data != -1) {
                data = r.read();
                System.out.println((char) data);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void fileWriter(String url, String text, boolean concat) {
        try (Writer w = new FileWriter(url, concat)) {
            w.write(text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void bufferWriter(String url, String text, boolean concat) {
        try (Writer w = new BufferedWriter(new FileWriter(url, concat), BUFFER_SIZE)) {
            w.write(text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // -----------------------------------------------------------
    ReadAndWriteTest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("CHOOSE");
        System.out.println("reader - writer - writingTime - readAndWrite - readerBuffer - writerBuffer");
        System.out
                .println("readingInputStreamBytesTimeTest - readingInputStreamByteArray - readingBufferedInputStream");
        String choice = sc.nextLine();
        switch (choice) {
            case "reader":
                System.out.println("READER PATH:");
                fileReaderPrint(sc.nextLine());
                break;
            case "fileWriter":
                System.out.println("WRITE PATH:");
                String path = sc.nextLine();
                System.out.println("TEXT:");
                String text = sc.nextLine();
                fileWriter(path, text, true);
                break;
            case "writingTime":
                System.out.println("writingTime PATH:");
                path = sc.nextLine();
                System.out.println("writingTime TEXT:");
                text = sc.nextLine();
                writingOutputTimeTest(path, text);
                break;
            case "readingInputStreamBytesTimeTest":
                System.out.println("readingInputStreamBytesTimeTest PATH:");
                path = sc.nextLine();
                readingInputStreamBytesTimeTest(path);
                break;
            case "readingInputStreamByteArrayTimeTest":
                System.out.println("readingInputStreamByteArrayTimeTest PATH:");
                path = sc.nextLine();
                readingInputStreamByteArrayTimeTest(path);
                break;
            case "readingBufferedInputStreamTimeTest":
                System.out.println("readingBufferedInputStreamTimeTest PATH:");
                path = sc.nextLine();
                readingBufferedInputStreamTimeTest(path);
                break;
            case "writingOutputTimeTest":
                System.out.println("writingOutputTimeTest PATH:");
                path = sc.nextLine();
                System.out.println("writingOutputTimeTest TEXT:");
                text = sc.nextLine();
                writingOutputTimeTest(path, text);
                break;
            case "readAndWriteTimeTest":
                System.out.println("readAndWriteTimeTest urlFrom:");
                String urlFrom = sc.nextLine();
                System.out.println("writingOutputTimeTest urlTo:");
                String urlTo = sc.nextLine();
                readAndWriteTimeTest(urlFrom, urlTo);
                break;

            case "readerBufferPrint":
                System.out.println("readerBufferPrint PATH:");
                path = sc.nextLine();
                bufferReaderPrint(path);
                break;
            case "bufferWriter":
                System.out.println("bufferWriter PATH:");
                path = sc.nextLine();
                System.out.println("bufferWriter TEXT:");
                text = sc.nextLine();
                bufferWriter(path, text, true);
                break;

            default:
                break;
        }
        sc.close();
    }

    public static void main(String[] args) {
        new ReadAndWriteTest();
    }
}
