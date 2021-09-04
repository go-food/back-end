package gofood.menu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gofood.base.BaseEntity;
import gofood.product.Product;
import gofood.restaurant.Restaurant;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu extends BaseEntity {
    @Column
    private String name;

    @OneToMany(mappedBy = "menu")
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
}
