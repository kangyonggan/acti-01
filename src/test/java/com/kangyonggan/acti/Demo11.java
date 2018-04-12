package com.kangyonggan.acti;

import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author kangyonggan
 * @date 4/11/18
 */
public class Demo11 extends AbstractServiceTest {

    @Autowired
    private HistoryService historyService;

    /**
     * 查询张三的请假申请
     */
    @Test
    public void queryHisIns() throws Exception {
        String processDefinitionKey = "LeaveProcess";
        List<HistoricProcessInstance> list = historyService
                .createHistoricProcessInstanceQuery()
                .processDefinitionKey(processDefinitionKey)
                .variableValueEquals("user", "zhangsan").list();

        for (HistoricProcessInstance hisIns : list) {
            System.out.println(hisIns);
        }
    }

    /**
     * 查询张三已完成的请假申请
     */
    @Test
    public void queryFinishdHisIns() throws Exception {
        String processDefinitionKey = "LeaveProcess";
        List<HistoricProcessInstance> list = historyService
                .createHistoricProcessInstanceQuery()
                .processDefinitionKey(processDefinitionKey).finished()
                .variableValueEquals("user", "zhangsan").list();

        for (HistoricProcessInstance hisIns : list) {
            System.out.println(hisIns);
        }
    }

    /**
     * 查询张三未完成的请假申请
     */
    @Test
    public void queryUnfinishdHisIns() throws Exception {
        String processDefinitionKey = "LeaveProcess";
        List<HistoricProcessInstance> list = historyService
                .createHistoricProcessInstanceQuery()
                .processDefinitionKey(processDefinitionKey).unfinished()
                .variableValueEquals("user", "zhangsan").list();

        for (HistoricProcessInstance hisIns : list) {
            System.out.println(hisIns);
        }
    }

    /**
     * 查询张三指定流水的请假申请
     */
    @Test
    public void queryBussKeyHisIns() throws Exception {
        String processDefinitionKey = "LeaveProcess";
        String businessKey = "20170411000001";
        List<HistoricProcessInstance> list = historyService
                .createHistoricProcessInstanceQuery()
                .processDefinitionKey(processDefinitionKey)
                .processInstanceBusinessKey(businessKey)
                .variableValueEquals("user", "zhangsan").list();

        for (HistoricProcessInstance hisIns : list) {
            System.out.println(hisIns);
        }
    }

}
