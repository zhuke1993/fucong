package com.zhuke.log.A;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ZHUKE on 2015/10/26.
 */
public class TestA {
    public static Logger logger = LoggerFactory.getLogger(TestA.class);
    public TestA(){
        logger.debug("TestA-debug");
        logger.info("TestA-info");
        logger.warn("TestA-warm");
        logger.error("TestA-error");
    }
}
