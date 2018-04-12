package com.kangyonggan.acti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author kangyonggan
 * @date 4/11/18
 */
public class Demo09 extends AbstractServiceTest {

    @Autowired
    private ProcessEngine processEngine;

    /**
     * 需求：部门经理想查询张三的请假申请。
     */
    @Test
    public void query() throws Exception {
        List<Task> tasks = processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee("manager")
                .processVariableValueEquals("user", "zhangsan")
                .list();

        for (Task task : tasks) {
            System.out.println(task);
        }

    }

}
