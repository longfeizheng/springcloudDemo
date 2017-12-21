package cn.merryyou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * http://localhost:8001/merryyou-config/dev
 * http://localhost:8001/merryyou-config/test
 * Created on 2017/12/21.
 *
 * @author zlf
 * @since 1.0
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
