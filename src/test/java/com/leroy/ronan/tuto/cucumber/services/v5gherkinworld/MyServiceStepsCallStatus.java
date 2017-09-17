package com.leroy.ronan.tuto.cucumber.services.v5gherkinworld;

import java.util.Optional;

import org.junit.Assert;

import cucumber.api.java.en.Then;

public class MyServiceStepsCallStatus {

    private MyServiceWorld world;

    public MyServiceStepsCallStatus(MyServiceWorld world) {
        this.world = world;
    }

    @Then("^it should have been a success$")
    public void it_should_have_been_a_success() throws Throwable {
        Assert.assertTrue(Optional.ofNullable(world.getServiceCallWasOk()).orElse(Boolean.TRUE));
    }

    @Then("^it should have been a failure$")
    public void it_should_have_been_a_failure() throws Throwable {
        Assert.assertFalse(world.getServiceCallWasOk());
    }
    
    @Then("^nothing should have happened$")
    public void nothing_should_have_happened() throws Throwable {
        Assert.assertNotNull(world.getServiceCallWasOk());
    }
}
