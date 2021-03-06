package gofood.restaurant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import gofood.account.Account;
import gofood.base.BaseEntity;
import gofood.menu.Menu;
import gofood.order.Order;
import gofood.request.Request;
import gofood.serializer.View;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "restaurant")
public class Restaurant extends BaseEntity {
    @Column(name = "address", nullable = false)
    @JsonView(View.General.class)
    private String address;

    @Column(name = "name", nullable = false)
    @JsonView(View.General.class)
    private String name;

    @Column(name = "openTime")
    @JsonView(View.General.class)
    private String openTime;

    @Column(name = "closeTime")
    @JsonView(View.General.class)
    private String closeTime;

    @Column(name = "description")
    @JsonView(View.General.class)
    private String description;

    @Column
    @JsonView(View.General.class)
    private String image;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonView(View.Detail.class)
    private List<Menu> menus;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonView(View.Admin.class)
    private List<Request> requests;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonView(View.Admin.class)
    @JsonIgnoreProperties({"restaurant"})
    private List<Order> orders;

    @ManyToMany(mappedBy = "restaurants")
    @JsonView(View.Admin.class)
    @JsonIgnoreProperties("restaurants")
    private Set<Account> owners;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenTime() {
        return openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Set<Account> getOwners() {
        return owners;
    }

    public void setOwners(Set<Account> owners) {
        this.owners = owners;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
