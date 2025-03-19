package backend;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import types.customer;
import types.product;
import types.product_ingredient;
import java.util.*;

public class productBackend extends database{
    
    public ArrayList<product> getProducts()
    {
        ArrayList<product> products = new ArrayList();
        try{
            String sql = "SELECT * FROM products";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                int price = rs.getInt("price");
                String size = rs.getString("size");
                String image = rs.getString("image");
                System.out.println(product_name);
                products.add(new product(product_id, product_name, price, size, image)); 
            }
            
            return products;
            
        } catch(Exception e){
            System.out.println(e);
        }
        
        return products;
    }
    
}
