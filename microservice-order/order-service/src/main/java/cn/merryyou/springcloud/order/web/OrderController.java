package cn.merryyou.springcloud.order.web;

import cn.merryyou.springcloud.commons.support.OAuthUser;
import cn.merryyou.springcloud.commons.support.UserContext;
import cn.merryyou.springcloud.order.api.OrderVO;
import cn.merryyou.springcloud.stock.api.IRemoteStock;
import cn.merryyou.springcloud.stock.api.ProductVO;
import cn.merryyou.springcloud.stock.api.StockVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 2017/12/13.
 *
 * @author zlf
 * @since 1.0
 */
@RestController
@EnableOAuth2Client
@RequestMapping(value = "/order")
@Slf4j
public class OrderController {

    @Autowired
    private IRemoteStock stock;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json") // 加上 consumes 表示该接口只接受 header 为 application/json 的接口调用
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

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<OrderVO> get(@PathVariable("id") long id){
        OAuthUser user = UserContext.getUser(); // this is the base user authorize information;
        ServiceInstance instance = client.getLocalServiceInstance();
        log.info("/get order, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", " + user.toString() );
        long productId = 1000; // mock a product id;
        ResponseEntity<ProductVO> entity = stock.getProduct( productId ); // then get the product from the Stock Service;
        ProductVO product = entity.getBody();
        OrderVO order = new OrderVO(id, product.getProductId(), product.getProductName(), 10 );
        log.info("order={}",order);
        return new ResponseEntity<OrderVO>(order, HttpStatus.OK );
    }
}
