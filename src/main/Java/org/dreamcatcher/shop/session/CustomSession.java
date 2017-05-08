package org.dreamcatcher.shop.session;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.context.request.RequestAttributes;

/**
 * Created by dreamcatcher on 19/09/16.
 */
public interface CustomSession {
    RequestAttributes getRequestAttributes();

    Authentication getAuthentication();

    void setAuthentication(String userName, String password);
}
