package org.example;

import org.example.DbException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.example.FileManager.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static String dir = System.getProperty("user.dir");


//    System.getProperty()
    public static void main(String[] args) throws DbException, IOException {
//        String fileSeparator = System.getProperty("file.separator");
//        System.out.println("current dir = " + fileSeparator);
        String name;

        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "":
                    break;
                case "ls":
                    tree(dir, "");
//                    list of the directory ////////////////////
                    break;
//                case "tree":
//                    tree(dir, "");
//                    break;
//                    list tree of the directory //////////
                case "cd":
                    name = scanner.nextLine();
                    if (cd(dir,name) == null) {
                        System.out.println("не существует");
                    }
                    else {
                        dir = cd(dir, name);
                    }
                    break;
                case "touch":
                    touch(dir);
                    break;
//                    create a file
                case "mkdir":
                    mkDir(dir);
                    break;
//                    create a directory
                case "rm":
                    dir = rm(dir);
                    break;
//                    delete
                case "current directory":
                    System.out.println(dir);
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }

}
