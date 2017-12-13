package cn.merryyou.springcloud.order.web;

import cn.merryyou.springcloud.order.api.OrderVO;
import cn.merryyou.springcloud.stock.api.IRemoteStock;
import cn.merryyou.springcloud.stock.api.StockVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2017/12/13.
 *
 * @author zlf
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/order")
@Slf4j
public class OrderController {

    @Autowired
    private IRemoteStock stock;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<OrderVO> create(@RequestBody OrderVO order) {
        ServiceInstance instance = client.getLocalServiceInstance();
        log.info("/create,host:{},service_id:{}", instance.getHost(), instance.getServiceId());

        //调用stock 微服务接口，进行库存扣减
        ResponseEntity<String> entity = stock.reduce(order.getProduct().getProductId(), new StockVO(order.getProduct().getProductId(),
                order.getProduct().getProductName(), order.getQuantity()));

        if (entity.getStatusCode().equals(HttpStatus.OK)) {
            log.info("====> success of creating the order with order id:{} ", order.getOrderId());
        } else {
            log.error("====> failed of creating the order with order id:{} ", order.getOrderId());
        }

        return new ResponseEntity<OrderVO>(order, HttpStatus.CREATED);
    }
}
