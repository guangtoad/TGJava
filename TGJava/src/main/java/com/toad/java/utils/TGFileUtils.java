package com.toad.java.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TGFileUtils {
    public static Boolean isExistDirectory(String path){
        File file = new File(path);
        return file.exists() && file.isDirectory();
    }

    public static String readFile(File file)throws IOException {
        //对一串字符进行操作
        StringBuffer fileData = new StringBuffer();
        //
        BufferedReader reader = new BufferedReader(new FileReader(file));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        //缓冲区使用完必须关掉
        reader.close();
        return fileData.toString();
    }
    //将file转化成string
    public static String readFile(String filePath)throws IOException {
        File file = new File(filePath);
        return readFile(file);
    }
}
