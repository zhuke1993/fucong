package com.zhuke.log;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ZHUKE on 2015/10/26.
 */
public class JDKLogging {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(JDKLogging.class.getSimpleName());
        logger.log(Level.INFO,"jdk log util test");
    }
}
