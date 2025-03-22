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
              
                products.add(new product(product_id, product_name, price, size, image)); 
            }
            
            return products;
            
        } catch(Exception e){
            System.out.println(e);
        }
        
        return products;
    }
    
    public void saveSoldItem(String order_id, int product_id, int quantity)
    {
        try{
            String sql = "INSERT INTO order_item (order_id, product_id, quantity) VALUES ( ?,?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, order_id);
            stmt.setInt(2, product_id);
            stmt.setInt(3, quantity);
            stmt.executeUpdate();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    public boolean checkIngredient(int product_id, int qty)
    {
        try{
            String sql = "SELECT * FROM product_ingredients where product_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, product_id);
            
            ResultSet rs = stmt.executeQuery();
            

            while (rs.next()) {
               int ingredient_needed = rs.getInt("ingredient_needed") * qty;
               int ingredient_id = rs.getInt("ingredient_id");
               
               ingredientBackend ingredientClass = new ingredientBackend();
              
               if(ingredientClass.checkStocks(ingredient_id, ingredient_needed))
               {
                   return true;
               }
           
               
            }
            
            
        } catch(Exception e){
            System.out.println("product error");
            System.out.println(e);
        }
        
        return false;
    }
    
    public void changeItemStocks(int product_id, int qty)
    {
        try{
            String sql = "SELECT * FROM product_ingredients where product_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, product_id);
            
            ResultSet rs = stmt.executeQuery();
            

            while (rs.next()) {
                int itemCountCost = rs.getInt("ingredient_needed") * qty;
                int ingredient_id = rs.getInt("ingredient_id");
                
                ingredientBackend ingredientClass = new ingredientBackend();
                
                ingredientClass.minusStocks(ingredient_id, itemCountCost);
            }
            
            
        } catch(Exception e){
            System.out.println("product error");
            System.out.println(e);
        }
        
    
    }
    
    
     public  int getCount()
    {
         try{
            String sql = "SELECT count(*) as item_count FROM products;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                return rs.getInt("item_count");
            }
            
        } catch(Exception e){
            System.out.println(e);
        }
         return 0;
    }
     
        public  int getSupplier()
    {
         try{
            String sql = "SELECT count(*) as item_count FROM supplier;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                return rs.getInt("item_count");
            }
            
        } catch(Exception e){
            System.out.println(e);
        }
         return 0;
    }
    
}
