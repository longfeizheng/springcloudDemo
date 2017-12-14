package cn.merryyou.springcloud.commons.support;

import cn.merryyou.springcloud.oauth.IUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2017/12/14.
 *
 * @author zlf
 * @since 1.0
 */
public class OAuthUser implements IUser {

    String username;

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    List<String> roles = new ArrayList<>();

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public List<String> getRoles() {
        return roles;
    }

    public static OAuthUser convert(Authentication auth) {
        if (auth == null) return null;
        OAuthUser u = new OAuthUser();
        u.setUsername((String) auth.getPrincipal());
        for (GrantedAuthority grantedAuthority : auth.getAuthorities()) {
            u.getRoles().add(grantedAuthority.getAuthority());
        }
        return u;
    }

    public String toString() {
        StringBuilder rr = new StringBuilder();

        for (String role : roles) {
            rr.append(role).append(", ");
        }
        return "user name: " + username + "; user roles: " + rr.toString();
    }
}
