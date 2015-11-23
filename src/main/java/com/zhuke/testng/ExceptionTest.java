package com.zhuke.testng;

import org.testng.annotations.Test;

/**
 * Created by zhuke on 2015/10/22.
 */
public class ExceptionTest {
    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp="NullPoint")
    public void testException(){
        throw new IllegalArgumentException("NullPoint");
    }
}
