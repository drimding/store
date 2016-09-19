package org.dreamcatcher.shop.service.impl;

import org.dreamcatcher.shop.dao.ProductCategoryDAO;
import org.dreamcatcher.shop.entity.ProductCategory;
import org.dreamcatcher.shop.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dreamcatcher on 13/09/16.
 */

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryDAO productCategoryDAO;

    public List<ProductCategory> getAllProductCategory() {

        return productCategoryDAO.findAll();
    }
}
