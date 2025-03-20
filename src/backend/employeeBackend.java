/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import types.employee;

/**
 *
 * @author U
 */
public class employeeBackend extends database{
      public employee getAccount(String username, String password)
    {
        try{
            String sql = "SELECT * FROM employee WHERE username = ? and password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idVal = rs.getInt("employee_id");
                String nameVal = rs.getString("name");
                String usernameVal = rs.getString("username");
                String passwordVal = rs.getString("password");
                return new employee(idVal, nameVal, usernameVal, passwordVal);
            }
            
        } catch(Exception e){
            System.out.println(e);
        }
        
        return new employee(0, "", "", "");
    }
}
