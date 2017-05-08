package org.dreamcatcher.shop.dao;

import org.dreamcatcher.shop.entity.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * Created by dreamcatcher on 18/09/16.
 */
public interface CustomUsersDAO extends JpaRepository<CustomUser, Integer> {
    @Query("FROM CustomUser cu WHERE LOWER(cu.email)=?1")
    CustomUser findLoginByEmail(String email);


}
