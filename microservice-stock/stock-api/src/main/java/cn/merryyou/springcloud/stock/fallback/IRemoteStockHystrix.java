package cn.merryyou.springcloud.stock.fallback;

import cn.merryyou.springcloud.stock.api.IRemoteStock;
import cn.merryyou.springcloud.stock.api.ProductVO;
import cn.merryyou.springcloud.stock.api.StockVO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Created on 2017/12/21.
 *
 * @author zlf
 * @since 1.0
 */
@Component
public class IRemoteStockHystrix implements IRemoteStock {
    @Override
    public ResponseEntity<String> reduce(long productid, StockVO stock) {
        return null;
    }

    @Override
    public ResponseEntity<ProductVO> getProduct(long productid) {
        System.out.println("【IRemoteStockHystrix 】 getProduct productid={}" + productid);
        return null;
    }
}
