package org.dreamcatcher.shop.entity;

import javax.persistence.*;

/**
 * Created by dreamcatcher on 09.09.16.
 */
@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private String sessionId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Products product;

    public Basket() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer amount) {
        this.quantity = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

}
