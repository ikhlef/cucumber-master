package com.leroy.ronan.tuto.cucumber.services.v1main;

import com.leroy.ronan.tuto.cucumber.services.MyService;

public class MyServiceTest {

    public static void main(String[] args) throws Throwable {
        MyService service = new MyService();
        boolean success = service.doSomething();
        if (!success) {
            throw new RuntimeException("Houston, we have a problem !");
        }
    }
}
