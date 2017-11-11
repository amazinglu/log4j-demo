package com.company;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        /**
         * set the level of logger
         * */
        logger.setLevel(Level.ALL);

        logger.trace("Entering application.");

        logger.info("display infor");
        logger.error("display errors");

        System.out.println("Log level is: " + logger.getLevel());

        System.out.println("Hello world");

        logger.trace("Exiting application.");
    }
}
