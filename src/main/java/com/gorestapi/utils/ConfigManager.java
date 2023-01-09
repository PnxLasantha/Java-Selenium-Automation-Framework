package com.gorestapi.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static ConfigManager manager;

    private final static Properties properties = new Properties();

    private ConfigManager(){
        InputStream inputStream = ConfigManager.class.getResourceAsStream("/config.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static ConfigManager getInstance(){
        if(manager == null){
            synchronized (ConfigManager.class){
                manager = new ConfigManager();
            }
        }
        return manager;
    }

    public String getString(String key){
        return System.getProperty(key, properties.getProperty(key));
    }

















}
