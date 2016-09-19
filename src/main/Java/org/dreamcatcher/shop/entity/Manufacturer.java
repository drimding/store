package org.dreamcatcher.shop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dreamcatcher on 09.09.16.
 */
@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "manufacturers")
    private List<Products> product;

    public Manufacturer() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Products> getProduct() {
        return product;
    }

    public void setProduct(List<Products> product) {
        this.product = product;
    }
}
