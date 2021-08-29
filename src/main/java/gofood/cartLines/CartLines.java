package gofood.cartLines;

import entities.CartEntity;
import gofood.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;

public class CartLines extends BaseEntity {
    @Id
    @Column
    private Integer cartId;
    @Column
    private Integer productId;
    @Column
    private Integer quantity;
    @Column
    private Double price;
    @Column
    private Double itemTotal;
    @Column
    private CartEntity cartByCartId;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
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

    public CartEntity getCartByCartId() {
        return cartByCartId;
    }

    public void setCartByCartId(CartEntity cartByCartId) {
        this.cartByCartId = cartByCartId;
    }
}
