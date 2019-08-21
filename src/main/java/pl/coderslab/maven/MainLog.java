package pl.coderslab.maven;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MainLog {

    private static final Logger log = LogManager.getLogger(MainLog.class);

    public static void main(String[] args) {
        log.debug("Debug");
        log.info("Info");
        log.warn("Warn");
        log.error("Error");
        log.fatal("Fatal");

        log.info("string: {}.");
    }

}
