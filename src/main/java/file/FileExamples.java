/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author C0FII
 */
public class FileExamples {

      private FileExamples() {
            Scanner sc = new Scanner(System.in);
            System.out.println("OPTIONS:");
            System.out.println("fileExist folderCreation foldersCreation fileRename fileDeletion");
            System.out.println("fileReader fileWriter");
            String option = sc.nextLine();
            switch (option) {
                  case "fileExist":
                        System.out.println("PATH: ");
                        fileExist(sc.nextLine());
                        break;
                  case "folderCreation":
                        System.out.println("PATH: ");
                        folderCreation(sc.nextLine());
                        break;
                  case "foldersCreation":
                        System.out.println("PATH: ");
                        foldersCreation(sc.nextLine());
                        break;
                  case "fileRename":
                        System.out.println("PATH ORIGINAL: ");
                        String originalPath = sc.nextLine();
                        System.out.println("PATH NEW: ");
                        String newPath = sc.nextLine();
                        fileRename(originalPath, newPath);
                        break;
                  case "fileDeletion":
                        System.out.println("PATH: ");
                        fileDeletion(sc.nextLine());
                        break;
                  case "fileReader":
                        fileReader(1);
                        break;
                  case "fileWriter":
                        fileWriter(2);
                        break;
                  default:
                        break;
            }

            sc.close();
      }

      // ++++++++++++++++++++++++++++++++++++++++++++++
      private void fileExist(String path) {
            File fileImage = new File(path);
            System.out.println("Does this file exist: " + fileImage.exists());

      }

      private void folderCreation(String path) {
            File newDirectory = new File(path);
            System.out.println("\nFolder Creation");
            if (newDirectory.mkdir()) {
                  System.out.println("\tTRUE");
            } else {
                  System.out.println("\tFALSE");
            }
      }

      private void foldersCreation(String path) {
            // "C:\\C0F\\Image\\new Folder\\magic1\\magic2\\magic3"
            File newDirectorys = new File(path);
            System.out.println("\nMultiple Folders Creation");
            if (newDirectorys.mkdirs()) {
                  System.out.println("\tTRUE");
            } else {
                  System.out.println("\tFALSE");
            }
      }

      private void fileRename(String oldPathName, String newPath) {
            File fileToBeRenamed = new File(oldPathName);
            System.out.println("\nRename a file");
            if (fileToBeRenamed.renameTo(new File(newPath))) {
                  System.out.println("\tTRUE");
            } else {
                  System.out.println("\tFALSE");
            }
      }

      private void fileDeletion(String path) {
            File fileToBeDeleted = new File(path);
            System.out.println("\nDelete a file");
            if (fileToBeDeleted.delete()) {
                  System.out.println("\tTRUE");
            } else {
                  System.out.println("\tFALSE");
            }
      }

      private void fileReader(int option) {
            if (option == 1) {
                  try {
                        FileReader fr = new FileReader("C:\\C0F\\Youtube Channels.txt");
                        BufferedReader br = new BufferedReader(fr);

                        System.out.println("\nRead a File (Using FileReader and BufferedReader)");
                        String line;
                        try {
                              while ((line = br.readLine()) != null) {
                                    System.out.println("\t" + line);
                              }

                              br.close();
                        } catch (IOException ex) {
                              Logger.getLogger(FileExamples.class.getName()).log(Level.SEVERE, null, ex);
                        }
                  } catch (FileNotFoundException ex) {
                        Logger.getLogger(FileExamples.class.getName()).log(Level.SEVERE, null, ex);
                  }
            } else if (option == 2) {
                  try {
                        FileInputStream in = new FileInputStream("C:\\C0F\\Youtube Channels.txt");
                        Scanner sc = new Scanner(in);
                        System.out.println("\nRead a File (Using FileInputStream and Scanner)");

                        while (sc.hasNext()) {
                              System.out.println("\t" + sc.next());
                        }
                        sc.close();
                  } catch (FileNotFoundException ex) {
                        Logger.getLogger(FileExamples.class.getName()).log(Level.SEVERE, null, ex);
                  }

            }
      }

      private void fileWriter(int option) {
            if (option == 1) {
                  try {
                        FileWriter fw = new FileWriter("C:\\C0F\\newTextFile.txt");
                        PrintWriter pw = new PrintWriter(fw);

                        System.out.println("\nWriting on a new TextFile a new Stream of Characters");
                        pw.println("Message From Java");

                        fw.close();
                  } catch (IOException ex) {
                        Logger.getLogger(FileExamples.class.getName()).log(Level.SEVERE, null, ex);
                  }
            } else if (option == 2) {
                  try {
                        FileWriter fw = new FileWriter("C:\\C0F\\PArtits.txt", true);
                        PrintWriter pw = new PrintWriter(fw);

                        System.out.println("\nWriting on an already created file and appending text to it");
                        pw.println("\nMessage From Java");

                        fw.close();
                  } catch (IOException ex) {
                        Logger.getLogger(FileExamples.class.getName()).log(Level.SEVERE, null, ex);
                  }
            }

      }

      // ++++++++++++++++++++++++++++++++++++++++++++++
      public static void main(String[] args) {
            new FileExamples();
      }

}
