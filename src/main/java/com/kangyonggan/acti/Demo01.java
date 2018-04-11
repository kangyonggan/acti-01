package com.kangyonggan.acti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

/**
 * @author kangyonggan
 * @date 4/11/18
 */
public class Demo01 {

    public static void main(String[] args) {
        ProcessEngineConfiguration cfg = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
                .setJdbcDriver("com.mysql.jdbc.Driver").setJdbcUrl("jdbc:mysql://127.0.0.1:3306/acti?characterEncoding=UTF-8")
                .setJdbcUsername("root").setJdbcPassword("123456").setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        ProcessEngine processEngine = cfg.buildProcessEngine();
        System.out.println(processEngine.getName());
    }

}
