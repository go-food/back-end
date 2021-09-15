package gofood.orderlines;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import gofood.base.BaseEntity;
import gofood.order.Order;
import gofood.product.Product;
import gofood.serializer.View;

import javax.persistence.*;

@Entity
@Table(name = "order_line")
public class OrderLine extends BaseEntity {

    @Column(nullable = false)
    @JsonView(View.General.class)
    private Integer quantity;

    @Column(nullable = false)
    @JsonView(View.General.class)
    private Double price;

    @Column(nullable = false)
    @JsonView(View.General.class)
    private Double itemTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnoreProperties({"restaurant", "category"})
    @JsonView(View.General.class)
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(Double itemTotal) {
        this.itemTotal = itemTotal;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
