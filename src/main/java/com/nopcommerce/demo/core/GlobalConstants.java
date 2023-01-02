package com.nopcommerce.demo.core;

import java.io.File;

public class GlobalConstants {

    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String SEPERATOR = File.separator;
    public static final String BROWSER_LOG_FIREFOX= PROJECT_PATH + SEPERATOR + "browserLogs"+ SEPERATOR+"firefox.log";
    public static final String CROSS_URL="";
}
