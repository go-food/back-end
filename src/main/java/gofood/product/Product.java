package gofood.product;

import entities.ProductCategoryEntity;
import gofood.account.Account;
import gofood.base.BaseEntity;
import gofood.productCategory.ProductCategory;
import gofood.restaurant.Restaurant;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Double price;

    @Column(name = "has_sold")
    private Integer hasSold;
    @Column(name = "active")
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id", nullable = false)
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private ProductCategory category;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getHasSold() {
        return hasSold;
    }

    public void setHasSold(Integer hasSold) {
        this.hasSold = hasSold;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public ProductCategory getProductCategoryByCategoryId() {
        return category;
    }

    public void setProductCategoryByCategoryId(ProductCategory category) {
        this.category = category;
    }
}
