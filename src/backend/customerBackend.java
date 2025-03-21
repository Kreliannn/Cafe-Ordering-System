
package backend;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import types.customer;

public class customerBackend extends database{
    
    public void addAccount(String name, String username, String password)
    {
        try{
            String sql = "INSERT INTO customer (name, username, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, username);
            stmt.setString(3, password);
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
    
    
     public String getName(int id)
    {
        try{
            String sql = "SELECT name FROM customer WHERE customer_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                return rs.getString("name");
            }
            
        } catch(Exception e){
            System.out.println(e);
        }
        
        return "user not found";
    }
}
