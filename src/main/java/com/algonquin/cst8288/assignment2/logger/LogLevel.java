package com.algonquin.cst8288.assignment2.logger;

/**
 * Enum representing different levels of logging severity.
 * Each log level has an associated integer value indicating its priority.
 */
public enum LogLevel {
    /** Trace level logging, typically used for fine-grained debug information */
    TRACE(1),

    /** Debug level logging, used for general debugging purposes */
    DEBUG(2),

    /** Info level logging, used for informational messages */
    INFO(3),

    /** Warn level logging, used for potentially harmful situations */
    WARN(4),

    /** Error level logging, used for error messages indicating a failure */
    ERROR(5);

    final int level;

    /**
     * Constructor for the LogLevel enum.
     *
     * @param level the integer value representing the log level
     */
    LogLevel(int level) {
        this.level = level;
    }
}