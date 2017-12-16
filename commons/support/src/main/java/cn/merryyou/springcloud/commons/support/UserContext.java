package cn.merryyou.springcloud.commons.support;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

/**
 * Created on 2017/12/14.
 *
 * @author zlf
 * @since 1.0
 */
public class UserContext {

    public static OAuthUser getUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if( securityContext == null ) return null;
        OAuth2Authentication oAuth = (OAuth2Authentication)securityContext.getAuthentication();
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) oAuth.getUserAuthentication();
        return OAuthUser.convert(token);
    }
}
