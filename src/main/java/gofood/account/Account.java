package gofood.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import gofood.base.BaseEntity;
import gofood.order.Order;
import gofood.restaurant.Restaurant;
import gofood.serializer.View;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account extends BaseEntity {
    @Column(name = "name", nullable = false)
    @JsonView(View.General.class)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    @JsonView(View.General.class)
    private String email;

    @Column(name = "password", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "phoneNumber", nullable = false)
    @JsonView(View.General.class)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    @JsonView(View.General.class)
    private String address;

    @Column(name = "role")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonView(View.General.class)
    private String role = "user";


    @OneToMany(mappedBy = "customer", orphanRemoval = true,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> orders;

    @ManyToMany
    @JoinTable(
            name = "account_restaurant",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "restaurant_id"))
    @JsonIgnore
    private Set<Restaurant> restaurants;

    @Column
    @JsonView(View.General.class)
    private String avatar;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
