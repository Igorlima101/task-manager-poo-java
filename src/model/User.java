package model;

import util.UserRole;

public class User {

    private String name;
    private String email;
    private UserRole userRole;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public User(String name, String email, UserRole userRole){
        this.name = name;
        this.email = email;
        this.userRole = userRole;
    }


}
