package cn.merryyou.springcloud.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2017/12/21.
 *
 * @author zlf
 * @since 1.0
 */
@RestController
@RefreshScope//使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public class ConfigController {
    @Value("${from}")
    private String from;

    //http://localhost:8082/from
    @RequestMapping(value = "/from")
    public String getFrom(){
        return this.from;
    }
}
