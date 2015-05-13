package com.Fairy.VocalsStudio.logic;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Wyvern on 12.05.2015.
 */
public class PageMapping {
   private Properties map;

    public PageMapping() throws IOException {
        map = new Properties();
        InputStream in = new FileInputStream("D:\\Dropbox (VideoGorillas)\\Shared\\Fairy\\idea projects\\VocalStudio\\web\\resources\\properties\\page_url_mapping.properties");
        map.load(in);
    }

    public String getValue(String key){
        return map.getProperty(key);
    }
}
