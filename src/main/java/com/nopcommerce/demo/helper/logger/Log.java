package com.nopcommerce.demo.helper.logger;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log {
    private static Logger logger = Logger.getLogger(Log.class);

    public static void info(String message){
        logger.info(message);
    }
    public static void error(String message){
        logger.error(message);
    }
    public static void debug(String message){
        logger.debug(message);
    }

    public static void allure(String message, Object... param){
        String msg = param.length == 0 ? message : String.format(message, param);
        step(msg);
        info(msg);
    }
    @Step("{message}")
    private static void step(String message){}
}
