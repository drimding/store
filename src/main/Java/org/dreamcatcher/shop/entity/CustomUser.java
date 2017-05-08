package org.dreamcatcher.shop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dreamcatcher on 09.09.16.
 */
@Entity
@Table(name = "Users")
public class CustomUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false, columnDefinition = "varchar(255) default 'USER'")
    private String permission;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String phone;
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "customUser")
    private List<Orders> orderses;

    public CustomUser() {
    }

    public CustomUser(String firstName, String lastName, String email, String address, String permission, String city, String password, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.permission = permission;
        this.city = city;
        this.password = password;
        this.phone = phone;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<Orders> getOrderses() {
        return orderses;
    }

    public void setOrderses(List<Orders> orderses) {
        this.orderses = orderses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    @Override
    public String toString() {
        return "CustomUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", permission='" + permission + '\'' +
                ", city='" + city + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
