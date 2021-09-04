package gofood.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import gofood.base.BaseEntity;
import gofood.orderlines.OrderLine;
import gofood.menu.Menu;
import gofood.restaurant.Restaurant;
import gofood.serializer.View;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {
    @Column(name = "name", nullable = false)
    @JsonView(View.General.class)
    private String name;

    @Column(name = "price", nullable = false)
    @JsonView(View.General.class)
    private Double price;

    @Column
    private String description;

    @Column
    private String image;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Menu menu;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<OrderLine> orderLines;

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
