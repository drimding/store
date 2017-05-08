package org.dreamcatcher.shop.entity;

import sun.util.resources.LocaleData;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


/**
 * Created by dreamcatcher on 19/09/16.
 */
@Entity
public class Orders {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "DATETIME")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime dateTime;
    @Column(nullable = false, columnDefinition="boolean default false")
    private boolean implementation;
    @Column(nullable = false, columnDefinition="boolean default false")
    private boolean verification;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private CustomUser customUser;
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "orders")
    private List<OrdersDetail> ordersDetailList;

    public Orders() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }



    public boolean isImplementation() {
        return implementation;
    }

    public void setImplementation(boolean implementation) {
        this.implementation = implementation;
    }

    public boolean isVerification() {
        return verification;
    }

    public void setVerification(boolean verification) {
        this.verification = verification;
    }

    public CustomUser getCustomUser() {
        return customUser;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }

    public List<OrdersDetail> getOrdersDetailList() {
        return ordersDetailList;
    }

    public void setOrdersDetailList(List<OrdersDetail> ordersDetailList) {
        this.ordersDetailList = ordersDetailList;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", implementation=" + implementation +
                ", verification=" + verification +
                ", customUser=" + customUser +
                ", ordersDetailList=" + ordersDetailList +
                '}';
    }
}
