package com.hasan.intro.to.spring.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserDetails {

    @Id
    @GeneratedValue
    private Long id;
    private Long gsmNo;
    @OneToOne
    private User user;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", foreignKey = @ForeignKey(name = "FK_USER_DETAILS_ADDRESS"))
    private List<Address> address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGsmNo() {
        return gsmNo;
    }

    public void setGsmNo(Long gsmNo) {
        this.gsmNo = gsmNo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public void addAddress(Address address) {
        this.address.add(address);
    }
}