package com.zhuke.test;

import com.zhuke.annotation.Test;

/**
 * Created by ZHUKE on 2015/10/19.
 */
public class Testable {
    public void execute() {
        System.out.println("executing ...");
    }

    @Test
    public void testExecute() {
        execute();
    }

    public static void main(String[] args) {
        new Testable().testExecute();
    }
}
