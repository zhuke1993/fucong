package com.zhuke.testng;

import org.springframework.util.StringUtils;
import org.testng.annotations.Test;

/**
 * Created by ZHUKE on 2015/10/22.
 */
public class HelloNG {
   /* @BeforeClass
    public void beforeClass() {
        System.out.println("this is before class");
    }
*/
   @Test
   public void isEmpty()
   {
       System.out.println("nimabi");
   }
    @Test
    public void trim()
    {
        assert "foo".equals(StringUtils.trimAllWhitespace("  foo   "));
    }

/*    @AfterClass
    public void afterClass() {
        System.out.println("this is after class");
    }*/
}
