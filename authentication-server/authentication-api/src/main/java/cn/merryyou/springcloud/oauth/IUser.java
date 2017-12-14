package cn.merryyou.springcloud.oauth;

import java.util.List;

/**
 *
 * Created on 2017/12/14.
 *
 * @author zlf
 * @since 1.0
 */
public interface IUser {

    public String getUsername();

    public List<String> getRoles();
}
