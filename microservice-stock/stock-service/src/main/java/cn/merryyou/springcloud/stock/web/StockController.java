package cn.merryyou.springcloud.stock.web;

import cn.merryyou.springcloud.stock.api.ProductVO;
import cn.merryyou.springcloud.stock.api.StockVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 2017/12/13.
 *
 * @author zlf
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/stock")
@Slf4j
public class StockController {

    @Autowired
    private DiscoveryClient client;

    /**
     * 扣减库存 ，模拟根据productid 来进行扣减库存
     *
     * @param productId
     * @param stock
     * @return
     */
    @RequestMapping(value = "/{productid}", method = RequestMethod.PUT)
    public ResponseEntity<String> reduce(@PathVariable long productId, @RequestBody StockVO stock) {
        ServiceInstance instance = client.getLocalServiceInstance();

        log.info("/reduce,host:{},service_id:{}", instance.getHost(), instance.getServiceId());

        log.info("====success reduced {} products with product id:{}", stock.getReduce(), productId);

        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{productid}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ProductVO> getProduct(@PathVariable long productid) {
        ServiceInstance instance = client.getLocalServiceInstance();
        log.info("/get product,host:{},service_id:{}", instance.getHost(), instance.getServiceId());
        ProductVO product = new ProductVO(productid, "sample");
        return new ResponseEntity<ProductVO>(product, HttpStatus.OK);
    }
}
