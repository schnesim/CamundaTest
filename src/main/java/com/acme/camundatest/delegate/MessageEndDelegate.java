package com.acme.camundatest.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class MessageEndDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
//        execution.getProcessEngineServices().getRuntimeService().correlateMessage("Message_2pp0065");
    }
    
}
