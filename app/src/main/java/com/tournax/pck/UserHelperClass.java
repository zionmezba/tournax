package com.tournax.pck;

public class UserHelperClass {
    String name, phone, email,country,username,password,interest;

    public UserHelperClass() {

    }

    public UserHelperClass(String name, String phone, String email, String country, String username, String password, String interest) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.country = country;
        this.username = username;
        this.password = password;
        this.interest = interest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
}
