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
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String name;
    @Column
    private String description;
    @Column
    private String openTime;
    @Column
    private String closeTime;

    @OneToMany(mappedBy = "restaurant")
    private List<Product> products;

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
}
