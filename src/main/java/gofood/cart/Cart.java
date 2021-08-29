package gofood.cart;

import gofood.base.BaseEntity;
import gofood.cartLines.CartLine;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart extends BaseEntity {
    @Column
    private Date orderDate;
    @Column
    private String note;
    @Column
    private String orderStatus;
    @Column
    private Double total;

    @OneToMany
    @JoinColumn(name = "cartId", referencedColumnName = "productid")
    private List<CartLine> lines;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
