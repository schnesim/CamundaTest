package com.acme.camundatest.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.impl.el.FixedValue;
import org.springframework.stereotype.Component;

@Component
public class SomeClassDelegate implements JavaDelegate {

    private FixedValue text;
    
    @Override
    public void execute(DelegateExecution de) throws Exception {
        System.out.println("Task did get executed");
    }

    public FixedValue getText() {
        return text;
    }

    public void setText(FixedValue text) {
        this.text = text;
    }
    
    
    
}
