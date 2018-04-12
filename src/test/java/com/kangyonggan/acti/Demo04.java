package com.kangyonggan.acti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.util.zip.ZipInputStream;

/**
 * @author kangyonggan
 * @date 4/11/18
 */
public class Demo04 extends AbstractServiceTest {

    @Autowired
    private ProcessEngine processEngine;

    /**
     * 部署流程定义
     */
    @Test
    public void deploy() throws Exception {
        String zipPath = "/Users/kyg/code/kyg/acti-01/src/main/resources/leave.zip";
        Deployment deployment = processEngine.getRepositoryService().createDeployment()
                .addZipInputStream(new ZipInputStream(new FileInputStream(zipPath))).deploy();

        System.out.println(deployment.getId());
    }

}
