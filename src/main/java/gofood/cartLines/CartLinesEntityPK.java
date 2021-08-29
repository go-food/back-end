package gofood.cartLines;

import gofood.product.Product;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CartLinesEntityPK implements Serializable {
    private Integer cartId;
    private Product productId;

    @Column(name = "cart_id")
    @Id
    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    @Column(name = "product_id")
    @Id
    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartLinesEntityPK that = (CartLinesEntityPK) o;

        if (cartId != null ? !cartId.equals(that.cartId) : that.cartId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartId != null ? cartId.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        return result;
    }
}
