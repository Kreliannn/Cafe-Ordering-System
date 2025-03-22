/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import types.ingredient;
import utils.customHooks;
import java.util.*;
/**
 *
 * @author U
 */
public class ingredientBackend extends database{
    
    public ArrayList<ingredient> getIngredients()
    {
        ArrayList<ingredient> ingredients = new ArrayList();
        try{
            String sql = "SELECT * FROM ingredients \n" +
            "join inventory on ingredients.ingredient_id = inventory.ingredient_id\n" +
            "join supplier on inventory.supplier_id = supplier.supplier_id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int ingredient_id = rs.getInt("ingredient_id");
                String ingredient_name = rs.getString("ingredient_name");
                int stocks = rs.getInt("stocks");
                String supplier = rs.getString("supplier_name");
               
                ingredients.add(new ingredient(ingredient_id, ingredient_name, stocks, supplier)); 
            }
            
            return ingredients;
            
        } catch(Exception e){
            System.out.println(e);
        }
        
        return ingredients;
    }
    
    public void restock(int ingredient_id, int stocks)
    {
         try{
            String sql = "update inventory set stocks = ? where ingredient_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, stocks);
            stmt.setInt(2, ingredient_id);
            stmt.executeUpdate();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public boolean checkStocks(int ingredient_id, int ingredient_needed)
    {
        try{
            String sql = "SELECT * FROM ingredients join inventory on ingredients.ingredient_id = inventory.ingredient_id where ingredients.ingredient_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ingredient_id);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
               if(ingredient_needed > rs.getInt("stocks"))
               {
                   customHooks.alert("error", ("out of " +  rs.getString("ingredient_name")));
                   return true;
               }
            }
            
            
        } catch(Exception e){
            System.out.println("engreidit error");
            System.out.println(e);
        }
        
        return false;
    }
    
    
    public void minusStocks(int ingredient_id, int ingredient_needed)
    {
        try{
            String sql = "SELECT * FROM ingredients join inventory on ingredients.ingredient_id = inventory.ingredient_id where ingredients.ingredient_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ingredient_id);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
              int newStocks = rs.getInt("stocks") - ingredient_needed;
              this.restock(ingredient_id, newStocks);
            }
            
            
        } catch(Exception e){
            System.out.println("engreidit error");
            System.out.println(e);
        }
        
       
    }
    
    
     public  int getCount()
    {
         try{
            String sql = "SELECT count(*) as item_count FROM ingredients;";
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
     
      public ArrayList<String> getProductIngredients(int id)
    {
        ArrayList<String> ingredients = new ArrayList();
        try{
            String sql = "SELECT * FROM product_ingredients  join ingredients on product_ingredients.ingredient_id = ingredients.ingredient_id  where product_ingredients.product_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("ingredient_name");
                int pcs = rs.getInt("ingredient_needed");
                ingredients.add(name + "  " + pcs + "pcs"); 
            }
            
            return ingredients;
            
        } catch(Exception e){
            System.out.println(e);
        }
        
        return ingredients;
    }
     
}
