package com.leroy.ronan.tuto.cucumber.services;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MyService {

    private Set<User> allowedUsers = new HashSet<>();
    
    public void allow(User user) {
        allowedUsers.add(user);
    }
    
    public boolean doSomething() {
        // [...]
        return true;
    }

    public boolean doAnything() {
        // [...]
        return false;
    }

    public boolean isWorking() {
        // [...]
        return true;
    }

    public Set<String> getUserNames(User user) {
        Set<String> res = null;
        if (allowedUsers.contains(user)) {
            res = allowedUsers.stream()
                .map(u -> u.getName())
                .collect(Collectors.toSet());
        }
        return res;
    }
    
}
