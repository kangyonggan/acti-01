package com.kangyonggan.acti;

import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author kangyonggan
 * @date 4/11/18
 */
public class Demo12 extends AbstractServiceTest {

    @Autowired
    private HistoryService historyService;

    /**
     * 查询部门经理的待办请假申请
     */
    @Test
    public void test1() {
        String processDefinitionKey = "LeaveProcess";
        List<HistoricTaskInstance> tasks = historyService
                .createHistoricTaskInstanceQuery()
                .processDefinitionKey(processDefinitionKey)
                .unfinished().taskAssignee("manager")
                .list();

        for (HistoricTaskInstance task : tasks) {
            System.out.println(task);
        }
    }

    /**
     * 查询部门经理的已办请假申请
     */
    @Test
    public void test2() {
        String processDefinitionKey = "LeaveProcess";
        List<HistoricTaskInstance> tasks = historyService
                .createHistoricTaskInstanceQuery()
                .processDefinitionKey(processDefinitionKey)
                .finished().taskAssignee("manager")
                .list();

        for (HistoricTaskInstance task : tasks) {
            System.out.println(task);
        }
    }

    /**
     * 查询部门经理的流水号为20170411000001的请假待办任务
     */
    @Test
    public void test3() {
        String processDefinitionKey = "LeaveProcess";
        List<HistoricTaskInstance> tasks = historyService
                .createHistoricTaskInstanceQuery()
                .processDefinitionKey(processDefinitionKey)
                .processInstanceBusinessKey("20170411000001")
                .taskAssignee("manager").list();

        for (HistoricTaskInstance task : tasks) {
            System.out.println(task);
        }
    }

    /**
     * 查询某次请假申请的流转和审批历史
     */
    @Test
    public void test4() {
        String processDefinitionKey = "LeaveProcess";
        List<HistoricTaskInstance> tasks = historyService
                .createHistoricTaskInstanceQuery()
                .processDefinitionKey(processDefinitionKey)
                .processInstanceBusinessKey("20170411000001")
                .list();

        for (HistoricTaskInstance task : tasks) {
            System.out.println(task);
        }
    }

    /**
     * 查询某次审批的审批意见和审批状态
     */
    @Test
    public void test5() {

    }

}
