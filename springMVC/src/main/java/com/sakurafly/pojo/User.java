package com.sakurafly.pojo;

public class User {

    private int id;
    private String password;
    private String username;
    private int age;
    private int isdelet;

    public User(String username, String password, int age) {
        this.username =username;
        this.password =password;
        this.age =age;

    }

    public User() {
    }

    public int getIsdelet() {
        return isdelet;
    }

    public void setIsdelet(int isdelet) {
        this.isdelet = isdelet;
    }

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

