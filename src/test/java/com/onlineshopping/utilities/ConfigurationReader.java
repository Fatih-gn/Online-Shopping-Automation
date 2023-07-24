package com.onlineshopping.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static final Properties properties = new Properties();

    static{

        try{
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            file.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method is used to read value from a configuration.properties file
     * @param keyword --> key name in configuration.properties file
     * @return --> value for the key. returns null if key is not found
     * driver.get(ConfigurationReader.getProperty("env"))
     */
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}
