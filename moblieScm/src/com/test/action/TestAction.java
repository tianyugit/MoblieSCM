package com.test.action;

import com.test.service.TestService;


public class TestAction {

    private String name;

    private TestService testService;

    public String execute() {
        System.out.println(name);
        name = testService.validateName(name);
        return "ret";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }

}
