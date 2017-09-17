package com.leroy.ronan.tuto.cucumber.services;

public class User {

    private String login;
    private String name;
    private String surname;
    
    public static User of(String login) {
        return new User(login);
    }
    
    public static User of(String login, String name, String surname) {
        return new User(login, name, surname);
    }
    
    private User(String login) {
        super();
        this.login = login;
    }
    
    private User(String login, String name, String surname) {
        this(login);
        this.name = name;
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        return true;
    }
}
