package gofood.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import gofood.base.BaseEntity;
import gofood.productCategory.ProductCategory;
import gofood.restaurant.Restaurant;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="price",nullable = false)
    private Double price;
    @Column(name="has_Sold")
    private Integer hasSold;
    @Column(name="active")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name="restaurant_id",referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties("products")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name="category_id",referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties("products")
    private ProductCategory category;

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
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
}
