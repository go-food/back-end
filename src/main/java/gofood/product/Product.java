package gofood.product;

import gofood.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Product extends BaseEntity {
    @Id
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Double price;
    @Column
    private Integer hasSold;
    @Column
    private Boolean active;
    @Column
    private Integer restaurantId;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
