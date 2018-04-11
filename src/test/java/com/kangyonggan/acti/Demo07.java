package com.kangyonggan.acti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kangyonggan
 * @date 4/11/18
 */
public class Demo07 extends AbstractServiceTest {

    @Autowired
    private ProcessEngine processEngine;

    /**
     * manager查询我的待办任务，并执行任务
     */
    @Test
    public void complete() throws Exception {
        // 查询任务
        String assignee = "manager";
        TaskQuery query = processEngine.getTaskService().createTaskQuery();
        query.taskAssignee(assignee);
        List<Task> tasks = query.list();

        // 执行任务
        Map<String, Object> variables = new HashMap<>(2);
        variables.put("status", "complete");
        variables.put("replyMsg", "准了");
        processEngine.getTaskService().complete(tasks.get(0).getId(), variables);
    }

}
