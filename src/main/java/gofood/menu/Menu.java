package gofood.menu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import gofood.base.BaseEntity;
import gofood.product.Product;
import gofood.restaurant.Restaurant;
import gofood.serializer.View;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu extends BaseEntity {
    @Column
    @JsonView(View.General.class)
    private String name;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    @JsonView(View.General.class)
    private List<Product> products;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Restaurant restaurant;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
