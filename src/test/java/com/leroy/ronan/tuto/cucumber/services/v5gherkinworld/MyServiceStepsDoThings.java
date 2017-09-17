package com.leroy.ronan.tuto.cucumber.services.v5gherkinworld;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyServiceStepsDoThings {

    private MyServiceWorld world;
    
    public MyServiceStepsDoThings(MyServiceWorld world){
        this.world = world;
    }

    @When("^my service does nothing$")
    public void my_service_does_nothing() throws Throwable {
        world.setServiceCallWasOk(true);
    }
    
    @When("^my service does something$")
    public void my_service_does_something() throws Throwable {
        boolean result = world.getService().doSomething();
        world.setServiceCallWasOk(result);
    }
    
    @When("^my service does anything$")
    public void my_service_does_anything() throws Throwable {
        boolean result = world.getService().doAnything();
        world.setServiceCallWasOk(result);
    }
    
    @Then("^my service should still be working$")
    public void my_service_should_still_be_working() throws Throwable {
        Assert.assertTrue(world.getService().isWorking());
    }
    
    @Then("^the service should answer in less than (\\d+\\.\\d+) seconds$")
    public void the_service_should_answer_in_less_than_milliseconds(double seconds) throws Throwable {
        long millis = Math.round(seconds * 1000);
        Duration max = Duration.of(millis, ChronoUnit.MILLIS);
        Assert.assertTrue(world.getCallDuration().compareTo(max) < 0);
    }
}
