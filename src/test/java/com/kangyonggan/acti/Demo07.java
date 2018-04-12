package com.kangyonggan.acti;

import org.activiti.engine.TaskService;
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
    private TaskService taskService;

    /**
     * manager查询我的待办任务，并执行任务
     */
    @Test
    public void complete() throws Exception {
        // 查询任务
        String assignee = "manager";
        TaskQuery query = taskService.createTaskQuery();
        query.taskAssignee(assignee);
        List<Task> tasks = query.list();

        // 执行任务
        Map<String, Object> transientVariables = new HashMap<>(2);
        transientVariables.put("status", "reject");
        transientVariables.put("replyMsg", "不可以");
        taskService.complete(tasks.get(0).getId(), new HashMap<>(), transientVariables);
    }

}
