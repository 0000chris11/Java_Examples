/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

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
public class FileTest {

      private FileTest() {
            //fileExist();
            //folderCreation();
            //foldersCreation();
            //fileRename();
            //fileDeletion();
            //fileReader(1);
            fileWriter(2);

      }

      //++++++++++++++++++++++++++++++++++++++++++++++
      private void fileExist() {
            File fileImage = new File("C:\\C0F\\Image\\nonomo__ - EtjGWSPVEAMU9JJ.jpg");
            System.out.println("Does this file exist: " + fileImage.exists());

      }

      private void folderCreation() {
            File newDirectory = new File("C:\\C0F\\Image\\new Folder");
            System.out.println("\nFolder Creation");
            if (newDirectory.mkdir()) {
                  System.out.println("\tTRUE");
            } else {
                  System.out.println("\tFALSE");
            }
      }

      private void foldersCreation() {
            File newDirectorys = new File("C:\\C0F\\Image\\new Folder\\magic1\\magic2\\magic3");
            System.out.println("\nMultiple Folders Creation");
            if (newDirectorys.mkdirs()) {
                  System.out.println("\tTRUE");
            } else {
                  System.out.println("\tFALSE");
            }
      }

      private void fileRename() {
            File fileToBeRenamed = new File("C:\\C0F\\Eu4fzb3VgAEZDo9.jpg");
            System.out.println("\nRename a file");
            if (fileToBeRenamed.renameTo(new File("C:\\C0F\\HXH UNK - W1.jpg"))) {
                  System.out.println("\tTRUE");
            } else {
                  System.out.println("\tFALSE");
            }
      }

      private void fileDeletion() {
            File fileToBeDeleted = new File("C:\\C0F\\DeleteThis.txt");
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
                        } catch (IOException ex) {
                              Logger.getLogger(FileTest.class.getName()).log(Level.SEVERE, null, ex);
                        }
                  } catch (FileNotFoundException ex) {
                        Logger.getLogger(FileTest.class.getName()).log(Level.SEVERE, null, ex);
                  }
            } else if (option == 2) {
                  try {
                        FileInputStream in = new FileInputStream("C:\\C0F\\Youtube Channels.txt");
                        Scanner sc = new Scanner(in);
                        System.out.println("\nRead a File (Using FileInputStream and Scanner)");
                        String line;

                        while (sc.hasNext()) {
                              System.out.println("\t" + sc.next());
                        }
                  } catch (FileNotFoundException ex) {
                        Logger.getLogger(FileTest.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(FileTest.class.getName()).log(Level.SEVERE, null, ex);
                  }
            }else if(option == 2){
                   try {
                        FileWriter fw = new FileWriter("C:\\C0F\\PArtits.txt", true);
                        PrintWriter pw = new PrintWriter(fw);

                        System.out.println("\nWriting on an already created file and appending text to it");
                        pw.println("\nMessage From Java");

                        fw.close();
                  } catch (IOException ex) {
                        Logger.getLogger(FileTest.class.getName()).log(Level.SEVERE, null, ex);
                  }
            }
            
            
      }

      //++++++++++++++++++++++++++++++++++++++++++++++
      public static void main(String[] args) {
            new FileTest();
      }

}
