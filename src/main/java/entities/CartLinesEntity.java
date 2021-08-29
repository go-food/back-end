package entities;

import javax.persistence.*;

@Entity
@Table(name = "cart_lines", schema = "public", catalog = "cloud")
@IdClass(CartLinesEntityPK.class)
public class CartLinesEntity {
    private Integer cartId;
    private Integer productId;
    private Integer quanity;
    private Double price;
    private Double itemTotal;
    private CartEntity cartByCartId;

    @Id
    @Column(name = "cart_id")
    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    @Id
    @Column(name = "product_id")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "quanity")
    public Integer getQuanity() {
        return quanity;
    }

    public void setQuanity(Integer quanity) {
        this.quanity = quanity;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "item_total")
    public Double getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(Double itemTotal) {
        this.itemTotal = itemTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartLinesEntity that = (CartLinesEntity) o;

        if (cartId != null ? !cartId.equals(that.cartId) : that.cartId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (quanity != null ? !quanity.equals(that.quanity) : that.quanity != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (itemTotal != null ? !itemTotal.equals(that.itemTotal) : that.itemTotal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartId != null ? cartId.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (quanity != null ? quanity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (itemTotal != null ? itemTotal.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id", nullable = false)
    public CartEntity getCartByCartId() {
        return cartByCartId;
    }

    public void setCartByCartId(CartEntity cartByCartId) {
        this.cartByCartId = cartByCartId;
    }
}
