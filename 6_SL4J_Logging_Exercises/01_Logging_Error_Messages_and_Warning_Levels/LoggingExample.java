package com.sample;

//Import Logger class (used to write logs like error, warning, info)
import org.slf4j.Logger;

//Import LoggerFactory (used to create logger object)
import org.slf4j.LoggerFactory;

public class LoggingExample {

 // Step 1: Create a logger object for this class
 // This tells SLF4J: "I want to log messages from this class"
 private static final Logger logger =
         LoggerFactory.getLogger(LoggingExample.class);

 public static void main(String[] args) {

     // Step 2: Log an ERROR message
     // ERROR = serious problem (application failure or critical issue)
     logger.error("This is an error message");

     // Step 3: Log a WARNING message
     // WARNING = something unusual, but program still continues
     logger.warn("This is a warning message");

     // (Optional understanding)
     // logger.info("This is an info message");   // general information
     // logger.debug("This is a debug message");   // debugging details

 }
}