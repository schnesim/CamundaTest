package com.acme.camundatest.endpoint;

import java.util.Optional;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.history.HistoricProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamundaTestEndpoint {
    
    @Autowired
    private RuntimeService runtimeService;
    
    @Autowired
    private HistoryService historyService;
    
    @RequestMapping(value = {"/save", "/save/{way}"})
    public String startProcess(@PathVariable Optional<String> way) throws InterruptedException {
        VariableMap variables = Variables.createVariables();
        variables.put("task", way.isPresent() ? way.get() : "");
        String businessKey = "someKey";
        int size = historyService.createHistoricProcessInstanceQuery().processInstanceBusinessKey(businessKey).list().size();
        ProcessInstance singleResult = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(businessKey).singleResult();
        runtimeService.startProcessInstanceByKey("Process_0ts9hy7", businessKey, variables);
        Thread.sleep(1000);
        ProcessInstance singleResult2 = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(businessKey).singleResult();
        System.out.println(singleResult);
        System.out.println(singleResult2);
        int newSize = historyService.createHistoricProcessInstanceQuery().processInstanceBusinessKey(businessKey).list().size();
        System.out.println(size + " " + newSize);
        return "good job";
    }
}
