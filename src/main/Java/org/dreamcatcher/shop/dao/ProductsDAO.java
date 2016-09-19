package org.dreamcatcher.shop.dao;

import org.dreamcatcher.shop.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dreamcatcher on 14/09/16.
 */

public interface ProductsDAO extends JpaRepository<Products, Integer> {

    @Transactional
    @Query("SELECT pr FROM Products pr JOIN FETCH pr.productCategory pc WHERE pc.id=?1")
    List<Products> findByProductCategoryId(Integer productCategoryId);
    @Query("FROM Products p WHERE p.id = ?1")
    Products findProductById(Integer id);
}
