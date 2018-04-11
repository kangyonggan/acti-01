package com.kangyonggan.acti;

import org.activiti.engine.ProcessEngine;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kangyonggan
 * @date 4/11/18
 */
public class Demo03 extends AbstractServiceTest {

    @Autowired
    private ProcessEngine processEngine;

    @Test
    public void test01() {
        System.out.println(processEngine.getName());
    }

}
