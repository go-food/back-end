package gofood.cartLines;

import entities.CartLinesEntityPK;
import gofood.base.BaseEntity;
import gofood.cart.Cart;
import gofood.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "cart_line")
@IdClass(CartLinesEntityPK.class)
public class CartLine extends BaseEntity{

    @Column
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", referencedColumnName = "id", nullable = false)
    private Cart cartId;
    @Column
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", referencedColumnName = "id", nullable = false)
    private Product productId;

    @Column
    private Integer quantity;
    @Column
    private Double price;
    @Column
    private Double itemTotal;

    public Cart getCartId() {
        return cartId;
    }

    public void setCartId(Cart cartId) {
        this.cartId = cartId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
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
