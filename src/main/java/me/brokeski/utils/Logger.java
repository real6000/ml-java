package me.brokeski.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Logger utility to print consistent timestamped messages to the console.
 * Useful for tracking training progress, debugging, and clean output.
 *
 * 2025
 */

public class Logger {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * Prints an info messsage with a timestamp.
     *
     * @param message The message to log.
     */
    public static void info(String message){
        System.out.printf("[%s} [INFO] %s%n", timestamp(), message);
    }

    /**
     * Prints a warning message with a timestamp.
     *
     * @param message The warning message.
     */
    public static void warn(String message){
        System.out.printf("[%s] [WARN] %s%n", timestamp(), message);
    }

    /**
     * Prints an error message with a timestamp.
     *
     * @param message The error message.
     */
    public static void error(String message) {
        System.err.printf("[%s] [ERROR] %s%n", timestamp(), message);
    }

    private static String timestamp(){
        return LocalTime.now().format(formatter);
    }
}
