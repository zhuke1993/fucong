package com.zhuke.log.B;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ZHUKE on 2015/10/26.
 */
public class TestB {
    public static Logger logger = LoggerFactory.getLogger(TestB.class);
    public TestB(){
        logger.debug("TestB-debug");
        logger.info("TestB-info");
        logger.warn("TestB-warm");
        logger.error("TestB-error");
    }
}
