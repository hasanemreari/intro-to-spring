package com.hasan.intro.to.spring.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "system_user")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    @Email
    @Column(unique = true)
    private String email;
    private String password;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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


}
