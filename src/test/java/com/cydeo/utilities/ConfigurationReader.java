package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    // 1 - create property obj
    private static Properties properties = new Properties();

    static {
        // create FileInputStream obj to open file as a stream in Java memory
        try {
            FileInputStream file = new FileInputStream("configuration.properties");

            // load "properties" obj with the "file" we opened using FileInputStream
            properties.load(file);
        } catch (IOException e) {
            System.out.println("File is not found in ConfigurationReader class");
            e.printStackTrace();
        }
    }
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}
