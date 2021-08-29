package gofood.cart;

import gofood.account.Account;
import gofood.base.BaseEntity;
import gofood.cartLines.CartLine;
import gofood.restaurant.Restaurant;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart extends BaseEntity {

    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "note")
    private String note;
    @Column(name = "order_status")
    private Boolean orderStatus;

    @Column(name = "total")
    private Double total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Account customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id", nullable = false)
    private Restaurant restaurantId;

    @OneToMany(mappedBy="cart")
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

    public Boolean getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
