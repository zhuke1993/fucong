package com.zhuke.mockito;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ZHUKE on 2015/11/2.
 */
public class MockitoTest {

    @Test
    public void mockitoTest() {
        List<String> list = mock(List.class);
        when(list.get(0)).thenReturn("zhuke");
        Assert.assertEquals("zhuke1", list.get(0));
    }
}
