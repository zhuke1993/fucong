package com.zhuke.log.C;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestC {

    public static Logger logger = LoggerFactory.getLogger(TestC.class);
    public TestC(){
        logger.debug("TestC-debug");
        logger.info("TestC-info");
        logger.warn("TestC-warm");
        logger.error("TestC-error");
    }

}
