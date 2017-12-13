package cn.merryyou.springcloud.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created on 2017/12/13.
 *
 * @author zlf
 * @since 1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaApplication.class).web(true).run(args);
    }
}
