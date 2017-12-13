package cn.merryyou.springcloud.stock.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created on 2017/12/13.
 *
 * @author zlf
 * @since 1.0
 */
@FeignClient("stock-service")
public interface IRemoteStock {

    @RequestMapping(value = "/stock/{productid}", method = RequestMethod.PUT)
    ResponseEntity<String> reduce(@PathVariable(value = "productid") long productid, @RequestBody StockVO stock);
}
