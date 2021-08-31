package gofood.cartLines;

import com.fasterxml.jackson.annotation.JsonBackReference;
import gofood.base.BaseEntity;
import gofood.cart.Cart;
import gofood.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "cart_line")
public class CartLine extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Double itemTotal;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

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
}
