package com.hasan.intro.to.spring.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_DETAILS_ID", foreignKey = @ForeignKey(name = "FK_USER_USER_DETAILS"))
    private UserDetails userDetails;

    @ManyToMany
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "FK_USER_ROLE")),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID", foreignKey = @ForeignKey(name = "FK_ROLE_USER")))
    private List<Role> role;

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

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public void addRole(Role role) {
        this.role.add(role);
    }
}
