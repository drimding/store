package org.dreamcatcher.shop.service.impl;

import org.dreamcatcher.shop.dao.CustomUsersDAO;
import org.dreamcatcher.shop.entity.CustomUser;
import org.dreamcatcher.shop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dreamcatcher on 18/09/16.
 */
@Service("userDetailsService")
public class LoginServiceImpl implements LoginService, UserDetailsService {
    @Autowired
    CustomUsersDAO usersDao;

    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("start logining");
        CustomUser user = null;
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        try {
            System.out.println(userName.toLowerCase());
            user = usersDao.findLoginByEmail(userName.toLowerCase());
            authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getPermission()));
            System.out.println(user);
        }catch (NoResultException e)
        {
            System.out.println("findLoginByEmail NoResultException");
            return null;
        }
        return new User(user.getEmail(), user.getPassword(),
                authorities);
    }
}
