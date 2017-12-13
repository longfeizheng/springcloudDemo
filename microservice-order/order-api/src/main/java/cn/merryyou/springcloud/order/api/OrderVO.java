package cn.merryyou.springcloud.order.api;

import cn.merryyou.springcloud.stock.api.ProductVO;

/**
 * 一个错略的Order
 * Created on 2017/12/13.
 *
 * @author zlf
 * @since 1.0
 */
public class OrderVO {
    public ProductVO getProduct() {
        return product;
    }

    public void setProduct(ProductVO product) {
        this.product = product;
    }

    long orderId;

    long productId;

    String productName;

    int quantity;

    ProductVO product;

    public OrderVO() {
    }

    public OrderVO(long orderId, long productId, String productName, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
