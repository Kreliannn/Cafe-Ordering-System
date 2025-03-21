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
    
    
    public ArrayList<order> getOrders()
    {
        ArrayList<order> orders = new ArrayList();
        try{
            String sql = "SELECT * FROM orders WHERE order_status = 'waiting'";
            PreparedStatement stmt = conn.prepareStatement(sql);
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
