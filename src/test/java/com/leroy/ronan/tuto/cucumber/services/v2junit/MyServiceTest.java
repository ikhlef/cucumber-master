package com.leroy.ronan.tuto.cucumber.services.v2junit;

import org.junit.Assert;
import org.junit.Test;

import com.leroy.ronan.tuto.cucumber.services.MyService;

public class MyServiceTest {

    @Test
    public void doSomething() throws Throwable {
        MyService service = new MyService();
        boolean success = service.doSomething();
        Assert.assertTrue("Houston, we have a problem !", success);
    }
}
