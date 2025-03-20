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
    
}
