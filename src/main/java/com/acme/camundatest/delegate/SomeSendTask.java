package com.acme.camundatest.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class SomeSendTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution de) throws Exception {
        System.out.println("Send task did get executed");
    }
    
    
}
