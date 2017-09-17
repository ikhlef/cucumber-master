package com.leroy.ronan.tuto.cucumber.services.v5gherkinworld;

import cucumber.api.java.en.Given;

public class MyServiceStepsBackground {

    private MyServiceWorld world;
    
    public MyServiceStepsBackground(MyServiceWorld world){
        this.world = world;
    }
    
    @Given("^my service exists$")
    public void my_service_exists() throws Throwable {
        world.createService();
    }
}
