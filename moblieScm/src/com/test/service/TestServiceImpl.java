package com.test.service;

public class TestServiceImpl implements TestService {

    /* (non-Javadoc)
     * @see net.beifeng.mobile_scm.test.service.TestService#validateName(java.lang.String)
     */
    public String validateName(String name) {
        if ("zhangsan".equalsIgnoreCase(name)) {
            return "welcome " + name;
        } else {
            return name + " is bad";
        }
    }
}
