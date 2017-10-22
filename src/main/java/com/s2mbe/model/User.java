package com.s2mbe.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class User {
    @Id
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;

    private String email;
    private String address;
    private String telephone;

    private Date birthDate;
    private Date registrationDate;

    private Credentials credentials;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof User)) return false;

        User user = (User) o;

        return new EqualsBuilder()
                .append(id, user.id)
                .append(firstName, user.firstName)
                .append(middleName, user.middleName)
                .append(lastName, user.lastName)
                .append(email, user.email)
                .append(address, user.address)
                .append(telephone, user.telephone)
                .append(birthDate, user.birthDate)
                .append(registrationDate, user.registrationDate)
                .append(credentials, user.credentials)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(firstName)
                .append(middleName)
                .append(lastName)
                .append(email)
                .append(address)
                .append(telephone)
                .append(birthDate)
                .append(registrationDate)
                .append(credentials)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("firstName", firstName)
                .append("middleName", middleName)
                .append("lastName", lastName)
                .append("email", email)
                .append("address", address)
                .append("telephone", telephone)
                .append("birthDate", birthDate)
                .append("registrationDate", registrationDate)
                .append("credentials", credentials)
                .toString();
    }
}
