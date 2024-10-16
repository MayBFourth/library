package com.librabymanagement.Model;

public class User {
    private Long id;
    private String name;
    private String password;
    private String email;
    private String phone;

    public User(){
        super();
    }

    public User(Long id, String phone, String email, String password, String name) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
