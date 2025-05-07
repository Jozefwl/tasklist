package com.waldhauser.tasklist.user;

public class User {
    private Long id;
    private String name;
    private String password;

    // Generate -> Constructors
    public User() {
    }

    public User(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    // One constructor without id bc database sets id
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // Generate -> Getter and Setter
    // Getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Generate -> toString (all)

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
