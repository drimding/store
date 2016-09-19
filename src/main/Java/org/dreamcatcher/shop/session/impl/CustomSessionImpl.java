package org.dreamcatcher.shop.session.impl;

import org.dreamcatcher.shop.session.CustomSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

/**
 * Created by dreamcatcher on 19/09/16.
 */
@Service
public class CustomSessionImpl implements CustomSession{
    public String getSessionID() {
        WebAuthenticationDetails session = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();

        return session.getSessionId();
    }

    public String getAuthenticationName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
