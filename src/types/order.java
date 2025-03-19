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
public class order {
    private int orderId;
    private int customerId;
    private int employeeId;
    private int totalAmount;
    private String orderDate;
    private String orderStatus;

    public order(int orderId, int customerId, int employeeId, int totalAmount, String orderDate, String orderStatus) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() { return orderId; }
    public int getCustomerId() { return customerId; }
    public int getEmployeeId() { return employeeId; }
    public int getTotalAmount() { return totalAmount; }
    public String getOrderDate() { return orderDate; }
    public String getOrderStatus() { return orderStatus; }
}
