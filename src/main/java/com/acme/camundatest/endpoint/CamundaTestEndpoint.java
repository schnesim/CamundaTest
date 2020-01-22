package com.acme.camundatest.endpoint;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamundaTestEndpoint {
    
    @Autowired
    private RuntimeService runtimeService;
    
    @RequestMapping("/save")
    public String startProcess() {
        runtimeService.startProcessInstanceByKey("Process_0ts9hy7");
        return "good job";
    }
}
