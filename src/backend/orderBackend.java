/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import types.customer;

/**
 *
 * @author U
 */
public class orderBackend extends database {
    
    public void addOrders(int customer_id, int total_amount, String order_date, String order_status)
    {
        try{
            String sql = "INSERT INTO orders (customer_id, employee_id, total_amount, date, order_status) VALUES (?,?,?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, customer_id);
            stmt.setInt(2, 1); // test
            stmt.setInt(3, total_amount);
            stmt.setString(4,order_date);
            stmt.setString(4,order_status);
            stmt.executeUpdate();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    public customer getAccount(String username, String password)
    {
        try{
            String sql = "SELECT * FROM customer WHERE username = ? and password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idVal = rs.getInt("customer_id");
                String nameVal = rs.getString("name");
                String usernameVal = rs.getString("username");
                String passwordVal = rs.getString("password");
                return new customer(idVal, nameVal, usernameVal, passwordVal);
            }
            
        } catch(Exception e){
            System.out.println(e);
        }
        
        return new customer(0, "", "", "");
    }
}
