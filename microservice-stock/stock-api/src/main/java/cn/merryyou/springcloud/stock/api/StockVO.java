package cn.merryyou.springcloud.stock.api;

/**
 * Created on 2017/12/13.
 *
 * @author zlf
 * @since 1.0
 */
public class StockVO {

    ProductVO product;

    String productName;

    //how many products should be reduced?
    int reduce;

    public StockVO() {
    }

    public StockVO(long productId, String productName, int reduce) {
        this.product = new ProductVO(productId, productName);
        this.productName = productName;
        this.reduce = reduce;
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
