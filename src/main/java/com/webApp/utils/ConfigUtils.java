package com.webApp.utils;

import java.util.ResourceBundle;

public class ConfigUtils {

    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    private ConfigUtils(){}

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
