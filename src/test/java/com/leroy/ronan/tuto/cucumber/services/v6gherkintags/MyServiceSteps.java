package com.leroy.ronan.tuto.cucumber.services.v6gherkintags;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;

import com.leroy.ronan.tuto.cucumber.services.MyService;
import com.leroy.ronan.tuto.cucumber.services.User;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyServiceSteps {

    private MyService service;
    private String message;
    
    private Duration callDuration;
    private Boolean success = null;
    private Set<String> userNames = null;
    
    @Given("^my service exists$")
    public void my_service_exists() throws Throwable {
        service = new MyService();
    }

    @Given("^allowed users are :$")
    public void allowed_users_are(List<Map<String, String>> data) throws Throwable {
        data.stream()
            .map(value -> User.of(value.get("login"), value.get("name"), value.get("surname")))
            .forEach(user -> service.allow(user));
    }
    
    @Given("^the messages is$")
    public void the_messages_is(String message) throws Throwable {
        this.message = message;
    }

    @When("^my service does something$")
    public void my_service_does_something() throws Throwable {
        success = service.doSomething();
    }
    
    @When("^my service does anything$")
    public void my_service_does_anything() throws Throwable {
        success = service.doAnything();
    }
    
    @When("^my service does nothing$")
    public void my_service_does_nothing() throws Throwable {
        success = true;
    }
    
    @When("^\"([^\"]*)\" calls my service, asking the user names$")
    public void calls_my_service_asking_the_user_names(String login) throws Throwable {
        User user = User.of(login);
        long start = System.currentTimeMillis();
        userNames = service.getUserNames(user);
        callDuration = Duration.of(System.currentTimeMillis() - start, ChronoUnit.MILLIS);
        success = true;
    }

    @Then("^it should have been a success$")
    public void it_should_have_been_a_success() throws Throwable {
        Assert.assertTrue(Optional.ofNullable(success).orElse(Boolean.TRUE));
    }

    @Then("^it should have been a failure$")
    public void it_should_have_been_a_failure() throws Throwable {
        Assert.assertFalse(success);
    }
    
    @Then("^my service should still be working$")
    public void my_service_should_still_be_working() throws Throwable {
        Assert.assertTrue(service.isWorking());
    }

    @Then("^nothing should have happened$")
    public void nothing_should_have_happened() throws Throwable {
        Assert.assertNotNull(success);
    }
    
    @Then("^the service should answer with (\\d+) elements$")
    public void the_service_should_answer_with_elements(int expected) throws Throwable {
        Assert.assertEquals(expected, userNames.size());
    }

    @Then("^the service should answer in less than (\\d+\\.\\d+) seconds$")
    public void the_service_should_answer_in_less_than_milliseconds(double seconds) throws Throwable {
        long millis = Math.round(seconds * 1000);
        Duration max = Duration.of(millis, ChronoUnit.MILLIS);
        Assert.assertTrue(callDuration.compareTo(max) < 0);
    }

    @Then("^the response should be \"([^\"]*)\"$")
    public void the_response_should_be(List<String> expected) throws Throwable {
        Assert.assertEquals(expected.stream().collect(Collectors.toSet()), userNames);
    }
    
    @Then("^message should have several lines$")
    public void message_should_have_several_lines() throws Throwable {
        message.chars();
    }

    
}
