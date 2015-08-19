package com.Fairy.VocalsStudio.logic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Wyvern on 12.05.2015.
 */
public class PageMapping {
   private Properties properties;

    public PageMapping() throws IOException {
        properties = new Properties();
        String propertiesAdres = "web/resources/properties/page_url_mapping.properties";
//        InputStream in = new FileInputStream("D:\\Dropbox (VideoGorillas)\\Shared\\Fairy\\idea projects\\VocalStudio\\web\\resources\\properties\\page_url_mapping.properties");
        InputStream in = new FileInputStream("C:\\Users\\Fairy\\Dropbox\\Fairy\\idea projects\\VocalStudio\\web\\resources\\properties\\page_url_mapping.properties");
        properties.load(in);
    }

    public String getValue(String key){
        return properties.getProperty(key);
    }
}
