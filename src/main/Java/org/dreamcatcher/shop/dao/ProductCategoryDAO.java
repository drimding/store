package org.dreamcatcher.shop.dao;

import org.dreamcatcher.shop.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dreamcatcher on 13/09/16.
 */
public interface ProductCategoryDAO extends JpaRepository <ProductCategory, Integer>{
    List<ProductCategory> findAll();
    ProductCategory findById(Integer id);

}
