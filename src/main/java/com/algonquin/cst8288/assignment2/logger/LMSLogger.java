package com.algonquin.cst8288.assignment2.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Singleton class for logging application messages to a log file.
 * Provides methods to log messages with different severity levels.
 */
public class LMSLogger {

    private static volatile LMSLogger instance;
    private static final String LOG_FILE = "application.log";
    private PrintWriter writer;

    /**
     * Private constructor to initialize the logger.
     * Opens the log file for writing in append mode.
     */
    private LMSLogger() {
        try {
            writer = new PrintWriter(new FileWriter(LOG_FILE, true));
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize logger", e);
        }
    }

    /**
     * Returns the singleton instance of the LMSLogger class.
     * If the instance does not exist, it is created in a thread-safe manner.
     *
     * @return the singleton instance of LMSLogger
     */
    public static LMSLogger getInstance() {
        if (instance == null) {
            synchronized (LMSLogger.class) {
                if (instance == null) {
                    instance = new LMSLogger();
                }
            }
        }
        return instance;
    }

    /**
     * Logs a message with the specified log level.
     *
     * @param level the severity level of the log message
     * @param message the message to log
     */
    private synchronized void log(LogLevel level, String message) {
        try {
            String logMessage = String.format("%s [%s]: %s",
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    level.name(),
                    message);
            writer.println(logMessage);
            writer.flush();
        } catch (Exception e) {
            System.err.println("Failed to write log message: " + e.getMessage());
        }
    }

    /**
     * Logs a message and a throwable with the specified log level.
     *
     * @param level the severity level of the log message
     * @param message the message to log
     * @param throwable the throwable to log
     */
    private synchronized void log(LogLevel level, String message, Throwable throwable) {
        try {
            String logMessage = String.format("%s [%s]: %s - %s",
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    level.name(),
                    message,
                    throwable.toString());
            writer.println(logMessage);
            for (StackTraceElement element : throwable.getStackTrace()) {
                writer.println("\tat " + element.toString());
            }
            writer.flush();
        } catch (Exception e) {
            System.err.println("Failed to write log message: " + e.getMessage());
        }
    }

    /**
     * Logs an informational message.
     *
     * @param message the message to log
     */
    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    /**
     * Logs a warning message.
     *
     * @param message the message to log
     */
    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    /**
     * Logs an error message.
     *
     * @param message the message to log
     */
    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    /**
     * Logs an error message with a throwable.
     *
     * @param message the message to log
     * @param throwable the throwable to log
     */
    public void error(String message, Throwable throwable) {
        log(LogLevel.ERROR, message, throwable);
    }

    /**
     * Logs a debug message.
     *
     * @param message the message to log
     */
    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    /**
     * Logs a trace message.
     *
     * @param message the message to log
     */
    public void trace(String message) {
        log(LogLevel.TRACE, message);
    }

    /**
     * Closes the logger and releases any system resources associated with it.
     */
    public void close() {
        writer.close();
    }
}