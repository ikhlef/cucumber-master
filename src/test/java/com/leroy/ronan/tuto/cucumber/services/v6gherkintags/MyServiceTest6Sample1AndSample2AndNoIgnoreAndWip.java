package com.leroy.ronan.tuto.cucumber.services.v6gherkintags;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict=true,
        tags = {"@sample1,@sample2", "~@ignore", "@wip"}
)
public class MyServiceTest6Sample1AndSample2AndNoIgnoreAndWip {

}
