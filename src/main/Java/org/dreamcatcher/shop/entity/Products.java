package org.dreamcatcher.shop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dreamcatcher on 09.09.16.
 */
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne (fetch = FetchType.LAZY)
    private ProductCategory productCategory;
    private String idn;
    @ManyToOne ( fetch = FetchType.LAZY)
    private Manufacturer manufacturers;
    @Column(nullable = false)
    private String nomenclature;
    @Column(nullable = false)
    private double priceUSD;
    @Column(nullable = false)
    private double priceUSDretail;
    private boolean inStock;
    @Column(nullable = false)
    private Integer productCode;
    private Integer warranty;
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "product")
    private List<Basket> baskets;
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "product")
    private List<OrdersDetail> ordersDetail;



    public Products() {
    }

    public List<OrdersDetail> getOrdersDetail() {
        return ordersDetail;
    }

    public void setOrdersDetail(List<OrdersDetail> ordersDetail) {
        this.ordersDetail = ordersDetail;
    }

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getIdn() {
        return idn;
    }

    public void setIdn(String idn) {
        this.idn = idn;
    }

    public Manufacturer getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(Manufacturer manufacturers) {
        this.manufacturers = manufacturers;
    }

    public String getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(String nomenclature) {
        this.nomenclature = nomenclature;
    }

    public double getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(double priceUSD) {
        this.priceUSD = priceUSD;
    }

    public double getPriceUSDretail() {
        return priceUSDretail;
    }

    public void setPriceUSDretail(double priceUSDretail) {
        this.priceUSDretail = priceUSDretail;
    }

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

    public Integer getWarranty() {
        return warranty;
    }

    public void setWarranty(Integer warranty) {
        this.warranty = warranty;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", productCategory=" + productCategory +
                ", idn='" + idn + '\'' +
                ", manufacturers=" + manufacturers +
                ", nomenclature='" + nomenclature + '\'' +
                ", priceUSD=" + priceUSD +
                ", priceUSDretail=" + priceUSDretail +
                ", inStock=" + inStock +
                ", productCode=" + productCode +
                ", warranty=" + warranty +
                ", baskets=" + baskets +
                ", orderses=" + ordersDetail +
                '}';
    }
}
