package com.leroy.ronan.tuto.cucumber.services.v5gherkinworld;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MyServiceStepsMessage {

    private String message;
    
    @Given("^the messages is$")
    public void the_messages_is(String message) throws Throwable {
        this.message = message;
    }

    @Then("^message should have several lines$")
    public void message_should_have_several_lines() throws Throwable {
        message.chars();
    }
}
