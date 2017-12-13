package cn.merryyou.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created on 2017/12/13.
 *
 * @author zlf
 * @since 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class StockApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(StockApplication.class).web(true).run(args);
    }
}
