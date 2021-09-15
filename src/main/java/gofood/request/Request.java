package gofood.request;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import gofood.base.BaseEntity;
import gofood.restaurant.Restaurant;
import gofood.serializer.View;

import javax.persistence.*;


@Entity
@Table(name = "request")
public class Request extends BaseEntity {
    @Column(name = "content", nullable = false)
    @JsonView(View.General.class)
    private String content;

    @Column(name = "status", nullable = false)
    @JsonView(View.General.class)
    private String status = "pending";

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Restaurant restaurant;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String requestStatus) {
        this.status = requestStatus;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
