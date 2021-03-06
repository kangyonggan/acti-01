package com.kangyonggan.acti;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kangyonggan
 * @date 4/11/18
 */
public class Demo06 extends AbstractServiceTest {

    @Autowired
    private TaskService taskService;

    /**
     * zhangsan查询我的待办任务，并执行任务
     */
    @Test
    public void complete() throws Exception {
        // 查询任务
        String businessKey = "20170411000002";
        TaskQuery query = taskService.createTaskQuery();
        query.processInstanceBusinessKey(businessKey);
        Task task = query.singleResult();

        // 执行任务
        Map<String, Object> variables = new HashMap<>(1);
        variables.put("reason", "请假去阿里面试， 求放过");
        taskService.complete(task.getId(), variables);
    }

}
