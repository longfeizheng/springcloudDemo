package cn.merryyou.springcloud.stock.api;

/**
 * Created on 2017/12/13.
 *
 * @author zlf
 * @since 1.0
 */
public class StockVO {

    long productId;

    String productName;

    //how many products should be reduced?
    int reduce;

    public StockVO() {
    }

    public long getProductId() {
        return productId;
    }



    public StockVO(long productId, String productName, int reduce) {
        this.productId = productId;
        this.productName = productName;
        this.reduce = reduce;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getReduce() {
        return reduce;
    }

    public void setReduce(int reduce) {
        this.reduce = reduce;
    }
}
