package gofood.restaurant;

import gofood.base.BaseEntity;
import gofood.product.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "restaurant")
public class Restaurant extends BaseEntity {
    @Column(name="address",nullable = false)
    private String address;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="openTime")
    private String openTime;
    @Column(name="closeTime")
    private String closeTime;
    @Column(name="active")
    private Boolean active;

    @OneToMany(mappedBy = "restaurant")
    private List<Product> products;

    public Restaurant() {
    }

    public Restaurant(String address, String name, String description, String openTime, String closeTime, Boolean active) {
        this.address = address;
        this.name = name;
        this.description = description;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.active = active;
    }

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
