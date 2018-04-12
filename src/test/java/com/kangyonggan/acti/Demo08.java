package com.kangyonggan.acti;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.ProcessEngine;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kangyonggan
 * @date 4/11/18
 */
public class Demo08 extends AbstractServiceTest {

    @Autowired
    private ProcessEngine processEngine;

    private static final String DEF_KEY = "LeaveProcess";

    /**
     * 挂起
     */
    @Test
    public void suspend() throws Exception {
        processEngine.getRepositoryService().suspendProcessDefinitionByKey(DEF_KEY);
    }

    /**
     * 激活
     */
    @Test
    public void active() throws Exception {
        processEngine.getRepositoryService().activateProcessDefinitionByKey(DEF_KEY);
    }

    /**
     * 启动一个工作流
     */
    @Test
    public void start() {
        try {
            // 业务主键，比如请假申请, 就可以使用请假的流水号
            String businessKey = "20170411000002";
            // 实例参数
            Map<String, Object> variables = new HashMap<>(1);
            // 谁请假?
            variables.put("user", "lisi");
            processEngine.getRuntimeService().startProcessInstanceByKey(DEF_KEY, businessKey, variables);
        } catch (ActivitiException e) {
            e.printStackTrace();
        }
    }

}
