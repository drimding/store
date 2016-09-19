package org.dreamcatcher.shop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dreamcatcher on 09.09.16.
 */
@Entity
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String catName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productCategory")
    private List<Products> product;

    public ProductCategory() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public List<Products> getProduct() {
        return product;
    }

    public void setProduct(List<Products> product) {
        this.product = product;
    }
}
