package com.acme.camundatest.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class TaskOne implements JavaDelegate {

    @Override
    public void execute(DelegateExecution arg0) throws Exception {
        System.out.println("TaskOne");
    }
    
}
