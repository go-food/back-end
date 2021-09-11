package gofood.request;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import gofood.base.BaseEntity;
import gofood.restaurant.Restaurant;
import gofood.serializer.View;

import javax.persistence.*;


@Entity
@Table(name = "restaurant")
public class Request extends BaseEntity {
    @Column(name = "content", nullable = false)
    @JsonView(View.General.class)
    private String content;

    @Column(name = "status", nullable = false)
    @JsonView(View.General.class)
    private RequestStatus requestStatus = RequestStatus.PENDING;

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

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
