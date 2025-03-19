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
    private int orderId;
    private String paymentDate;
    private double paymentAmount;
    private String paymentMethod;

    public payment(int paymentId, int orderId, String paymentDate, double paymentAmount, String paymentMethod) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentId() { return paymentId; }
    public int getOrderId() { return orderId; }
    public String getPaymentDate() { return paymentDate; }
    public double getPaymentAmount() { return paymentAmount; }
    public String getPaymentMethod() { return paymentMethod; }
}
