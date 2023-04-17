package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
//    public static final String path = "/Users/yazgul/Documents/Files";
    public static void main( String[] args ) throws DbException {
        String p = "/Users/yazgul/Documents/Files";
//        tree(p, "");
//        cd(p);
        System.out.println(System.getProperty("user.dir"));
    }
    public static String cd (String path, String name) throws DbException {
        String[] split = path.split("/", 0);
        String way = "";
        for(int i = 0; i < split.length - 1; i++) {
            way = way + "/";
            way = way + split[i];
        }
        way = way + "/" + name;
        File file = new File(way);
        if (!file.exists()) {
            return null;
        }
        return way;
    }
//    переход к папке которая есть в каталоге по его адресу, dir передаем в string path

    public static String back (String path) throws DbException {
        String[] split = path.split("/", 0);
        if (split.length < 1) {
            System.out.println("в корневой папке");
            return null;
        }
        String way = "";
        for(int i = 0; i < split.length - 1; i++) {
            way = way + "/";
            way = way + split[i];
        }
        return way;
    }
    public static void touch (String path) throws DbException, IOException {
        String way = path + "/" + "newFile.txt";
        File file = new File(way);
//        File file = new File(way);
        file.createNewFile();
//        if (file.createNewFile()) {
//            System.out.println("файл создан");
//        }
//        else {
//            System.out.println("файл существует");
//        }
    }
    public static void mkDir (String path) throws DbException, IOException {
        String way = path + "/" + "newFile.txt";
        new File(way).mkdir();
    }
    public static String rm (String path) throws DbException, IOException {
        File file = new File(path);
        if ((!file.isDirectory()) || (file == null)) {
            file.delete();
            return back(path);
        }

        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                rm(files[i].getPath());
            } else {
                files[i].delete();
            }
        }
        return back(path);
    }

    public static void tree (String path, String x) throws DbException {
//        boolean existsF = false;
//        boolean isDirectory = true;
        File dir = new File(path);
        if (!dir.exists()) {
            System.out.println("Файл не найден");
            return;
        }
        if (!dir.isDirectory()) {
            System.out.println("Это файл: " + dir.getName());
            return;
        }
        if (dir == null) {
            System.out.println("Папка" + dir.getName() + "пустая");
            return;
//            чтобы лишний раз не писать в след раз тк и так папка пустая
        }
        System.out.println(x + dir.getName());
        File[] files = dir.listFiles();
        x = x + "|_" ;
        for (int i = 0; i < files.length; i++) {
            if(files[i].isDirectory()) {
                tree(files[i].getPath(), x);
            }
            else{
                System.out.println(x + files[i].getName());
            }
        }

    }
}
