package cn.merryyou.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Created on 2017/12/13.
 *
 * @author zlf
 * @since 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class StockApplication extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/stock/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.PUT, "/stock/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.GET, "/stock/**").access("#oauth2.hasScope('read')");

    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(StockApplication.class).web(true).run(args);
    }
}
