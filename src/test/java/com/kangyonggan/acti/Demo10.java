package com.kangyonggan.acti;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author kangyonggan
 * @date 4/11/18
 */
public class Demo10 extends AbstractServiceTest {

    @Autowired
    private TaskService taskService;

    /**
     * 需求：部门经理想查询张三和李四的请假申请。
     */
    @Test
    public void query() throws Exception {
        String sql = "SELECT a.* FROM ACT_RU_TASK a "
                + "LEFT JOIN ACT_RU_VARIABLE b "
                + "ON a.PROC_INST_ID_ = b.PROC_INST_ID_ WHERE "
                + "b.NAME_ = 'user' AND b.TEXT_ IN ('zhangsan', 'lisi')";

        List<Task> tasks = taskService.createNativeTaskQuery()
                .sql(sql).list();

        for (Task task : tasks) {
            System.out.println(task);
        }

    }

}
