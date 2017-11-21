package com.s2mbe.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Credentials {
    private String userName;
    private String password;
    private String role;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
