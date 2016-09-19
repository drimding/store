package org.dreamcatcher.shop.service;

import org.dreamcatcher.shop.entity.Products;

import java.util.List;

/**
 * Created by dreamcatcher on 14/09/16.
 */
public interface ProductsService {
    List<Products> getProductsByProductCategoryId(String Id);
}
