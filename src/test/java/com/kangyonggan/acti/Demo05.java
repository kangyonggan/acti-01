package com.kangyonggan.acti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kangyonggan
 * @date 4/11/18
 */
public class Demo05 extends AbstractServiceTest {

    @Autowired
    private ProcessEngine processEngine;

    /**
     * 启动流程实例
     */
    @Test
    public void start() throws Exception {
        // 流程定义ID， 指明了流程定义ID，引擎才能知道你使用的是哪个模板
        String processDefinitionId = "LeaveProcess";
        // 业务主键，比如请假申请, 就可以使用请假的流水号
        String businessKey = "20170411000001";
        // 实例参数
        Map<String, Object> variables = new HashMap<>(1);
        // 谁请假?
        variables.put("user", "zhangsan");

        ProcessInstance processInstance = processEngine.getRuntimeService().
                startProcessInstanceByKey(processDefinitionId, businessKey, variables);
        System.out.println(processInstance.getId());
    }

}
