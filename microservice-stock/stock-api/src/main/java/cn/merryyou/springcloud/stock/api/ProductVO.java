package cn.merryyou.springcloud.stock.api;

/**
 * Created on 2017/12/13.
 *
 * @author zlf
 * @since 1.0
 */
public class ProductVO {

    long productId;

    String productName;

    public ProductVO() {
    }

    public ProductVO(long productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public long getProductId() {
        return productId;
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

    @Override
    public String toString() {
        return "ProductVO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                '}';
    }
}
