package com.leroy.ronan.tuto.cucumber.services.v3gherkinsimple;

import org.junit.Assert;

import com.leroy.ronan.tuto.cucumber.services.MyService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyServiceSteps {

    private MyService service;
    private boolean success;
    
    @Given("^my service exists$")
    public void my_service_exists() throws Throwable {
        service = new MyService();
    }

    @When("^my service does something$")
    public void my_service_does_something() throws Throwable {
        success = service.doSomething();
    }

    @Then("^it should have been a success$")
    public void it_should_have_been_a_success() throws Throwable {
        Assert.assertTrue(success);
    }
}
