package com.leroy.ronan.tuto.cucumber.services.v5gherkinworld;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Set;

import com.leroy.ronan.tuto.cucumber.services.MyService;

public class MyServiceWorld  {

    private MyService service;
    
    private Boolean serviceCallWasOk;

    private Long start;
    private Duration callDuration;
    
    public void createService() { 
        service = new MyService();
    }

    public MyService getService() {
        start = Long.valueOf(System.currentTimeMillis());
        return service;
    }

    public void setServiceCallWasOk(boolean result) {
        serviceCallWasOk = result;
        if (start != null) {
            callDuration = Duration.of(System.currentTimeMillis() - start, ChronoUnit.MILLIS);
            this.start = null;
        }
    }
    
    public boolean getServiceCallWasOk(){
        return serviceCallWasOk;
    }
    
    public Duration getCallDuration() {
        return callDuration;
    }
}
