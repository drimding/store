package org.dreamcatcher.shop.session.impl;

import org.dreamcatcher.shop.session.CustomSession;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dreamcatcher on 19/09/16.
 */
@Service
public class CustomSessionImpl implements CustomSession{
    public RequestAttributes getRequestAttributes() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        return requestAttributes;
    }

    public Authentication getAuthentication() {
         Authentication authentication = null;
         authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

    public void setAuthentication(String userName, String password) {

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        Authentication authentication = new UsernamePasswordAuthenticationToken(userName, password, authorities);
        System.out.println(authentication.getDetails());

        SecurityContextHolder.getContext().setAuthentication(authentication);

    }


}
