package com.acme.camundatest.endpoint;

import java.util.Optional;
import org.camunda.bpm.engine.RuntimeService;
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
    
    @RequestMapping(value = {"/save", "/save/{way}"})
    public String startProcess(@PathVariable Optional<String> way) {
//        if (way.isEmpty()) {
//            return "bad job";
//        }
        VariableMap variables = Variables.createVariables();
        variables.put("task", way.get());
        runtimeService.startProcessInstanceByKey("Process_0ts9hy7", variables);
        return "good job";
    }
}
