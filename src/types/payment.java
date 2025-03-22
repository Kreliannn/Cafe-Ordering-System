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
public class payment {
        private int paymentId;
    private String orderId;
    private String paymentDate;
    private int paymentAmount;
    private String paymentMethod;

    public payment(int paymentId, String orderId, String paymentDate, int paymentAmount, String paymentMethod) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentId() { return paymentId; }
    public String getOrderId() { return orderId; }
    public String getPaymentDate() { return paymentDate; }
    public int getPaymentAmount() { return paymentAmount; }
    public String getPaymentMethod() { return paymentMethod; }
}
