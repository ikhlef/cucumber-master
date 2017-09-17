package com.leroy.ronan.tuto.cucumber.services.v5gherkinworld;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;

import com.leroy.ronan.tuto.cucumber.services.User;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyServiceStepsUsers {

    private MyServiceWorld world;

    private Set<String> userNames = null;
    
    public MyServiceStepsUsers(MyServiceWorld world) {
        this.world = world;
    }

    @Given("^allowed users are :$")
    public void allowed_users_are(List<Map<String, String>> data) throws Throwable {
        data.stream()
            .map(value -> User.of(value.get("login"), value.get("name"), value.get("surname")))
            .forEach(user -> world.getService().allow(user));
    }
    
    @When("^\"([^\"]*)\" calls my service, asking the user names$")
    public void calls_my_service_asking_the_user_names(String login) throws Throwable {
        User user = User.of(login);
        userNames = world.getService().getUserNames(user);
        world.setServiceCallWasOk(true);
    }

    @Then("^the service should answer with (\\d+) elements$")
    public void the_service_should_answer_with_elements(int expected) throws Throwable {
        Assert.assertEquals(expected, userNames.size());
    }

    @Then("^the response should be \"([^\"]*)\"$")
    public void the_response_should_be(List<String> expected) throws Throwable {
        Assert.assertEquals(expected.stream().collect(Collectors.toSet()), userNames);
    }
}
