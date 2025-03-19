/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

/**
 *
 * @author U
 */
public class order_item {
     private int orderItemId;
    private int orderId;
    private int productId;
    private int quantity;

    public order_item(int orderItemId, int orderId, int productId, int quantity) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getOrderItemId() { return orderItemId; }
    public int getOrderId() { return orderId; }
    public int getProductId() { return productId; }
    public int getQuantity() { return quantity; }
}
