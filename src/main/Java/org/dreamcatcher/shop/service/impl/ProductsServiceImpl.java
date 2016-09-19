package org.dreamcatcher.shop.service.impl;

import org.dreamcatcher.shop.dao.ProductCategoryDAO;
import org.dreamcatcher.shop.dao.ProductsDAO;
import org.dreamcatcher.shop.entity.Products;
import org.dreamcatcher.shop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dreamcatcher on 14/09/16.
 */
@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    ProductsDAO productsDAO;



    public List<Products> getProductsByProductCategoryId(String id) {
        try {
            int intID = Integer.parseInt(id);
            return  productsDAO.findByProductCategoryId(intID);
        }catch (NumberFormatException e){
            return null;
        }
    }
}
