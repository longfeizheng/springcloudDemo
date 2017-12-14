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

    int quantity;

    ProductVO product;

    public OrderVO() {
    }

    public OrderVO(long orderId, long productId, String productName, int quantity) {
        this.orderId = orderId;
        product = new ProductVO(productId, productName);
        this.quantity = quantity;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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
                ", quantity=" + quantity +
                '}';
    }
}
