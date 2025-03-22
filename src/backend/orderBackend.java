/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import types.customer;
import java.util.*;
import types.order;
import types.payment;
/**
 *
 * @author U
 */
public class orderBackend extends database {
    
    public void addOrders(String orderId, int customer_id, int total_amount, String order_date, String order_status)
    {
        try{
            String sql = "INSERT INTO orders ( customer_id, employee_id, total_amount, order_date, order_status, order_id) VALUES (?,?,?,?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, customer_id);
            stmt.setInt(2, 1); // test
            stmt.setInt(3, total_amount);
            stmt.setString(4,order_date);
            stmt.setString(5,order_status);
            stmt.setString(6,orderId);
            stmt.executeUpdate();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void addPayment(payment newPayment)
    {
        try{
            String sql = "INSERT INTO payment ( order_id, payment_method, payment_amount, payment_date) VALUES (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, newPayment.getOrderId());
            stmt.setString(2, newPayment.getPaymentMethod()); // test
            stmt.setInt(3, newPayment.getPaymentAmount());
            stmt.setString(4,newPayment.getPaymentDate());
          
            stmt.executeUpdate();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
      public void rejectOrder(String id)
    {
        try{
            String sql = "delete from orders where order_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
       
          
            stmt.executeUpdate();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    
     public void changeStatus(String orderId, String status)
    {
        try{
            String sql = "update orders set order_status = ? where order_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setString(2, orderId);
         
            stmt.executeUpdate();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    public ArrayList<order> getOrders(String status, String status2 )
    {
        ArrayList<order> orders = new ArrayList();
        try{
            String sql = "SELECT * FROM orders WHERE order_status = ? or order_status = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setString(2, status2);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                String orderId = rs.getString("order_id");
                int customerId = rs.getInt("customer_id");
                int employeeId = rs.getInt("employee_id");
                int totalAmount = rs.getInt("total_amount");
                String orderDate = rs.getString("order_date");
                String orderStatus = rs.getString("order_status");
                orders.add(new order(orderId,customerId, employeeId, totalAmount, orderDate, orderStatus));
            }
            
        } catch(Exception e){
            System.out.println(e);
        }
        
        return orders;
    }
}
