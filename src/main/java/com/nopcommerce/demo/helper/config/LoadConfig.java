package com.nopcommerce.demo.helper.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class LoadConfig {
    public static final LoadConfig LOAD_CONFIG = getInstance();
    private final Config conf;

    private LoadConfig() {
        conf = ConfigFactory.load("application.conf");
    }

    public static LoadConfig getInstance() {
        return new LoadConfig();
    }

    public String getProperty(String key) {

        Config env = conf.getConfig("market");
        return env.getString(key);
    }
}
