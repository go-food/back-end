package gofood.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import gofood.account.Account;
import gofood.base.BaseEntity;
import gofood.orderlines.OrderLine;
import gofood.restaurant.Restaurant;
import gofood.serializer.View;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonView(View.General.class)
    private Date orderDate;

    // Name of the person to contact when deliver
    @Column
    @JsonView(View.General.class)
    private String contactName;

    // Deliver address of the order
    @Column
    @JsonView(View.General.class)
    private String address;

    // Phone number to call when deliver
    @Column
    @JsonView(View.General.class)
    private String phoneNumber;

    @Column
    @JsonView(View.General.class)
    private String note;

    @Column(name = "status")
    @JsonView(View.General.class)
    private String status = "pending";

    @Column(name = "total")
    @JsonView(View.General.class)
    private Double total;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    @JsonView(View.General.class)
    private Account customer;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties("products")
    @JsonView(View.General.class)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonView(View.General.class)
    private List<OrderLine> orderLines;

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Account getCustomer() {
        return customer;
    }

    public void setCustomer(Account customer) {
        this.customer = customer;
    }

    @JsonView(View.General.class)
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<OrderLine> getCartLines() {
        return orderLines;
    }

    public void setCartLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String orderStatus) {
        this.status = orderStatus;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
