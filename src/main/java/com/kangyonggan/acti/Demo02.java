package com.kangyonggan.acti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

/**
 * @author kangyonggan
 * @date 4/11/18
 */
public class Demo02 {

    public static void main(String[] args) {
        ProcessEngineConfiguration cfg = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine processEngine = cfg.buildProcessEngine();
        System.out.println(processEngine.getName());
    }

}
