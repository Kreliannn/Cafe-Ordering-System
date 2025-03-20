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
public class ingredient {
    private int ingredientId;
    private String ingredientName;
    private int stocks;
    private String supplier;
    
     public ingredient() {
        
    }

    public ingredient(int ingredientId, String ingredientName, int stocks, String supplier) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.stocks = stocks;
        this.supplier = supplier;
    }

    public int getIngredientId() { return ingredientId; }
    public String getIngredientName() { return ingredientName; }
    public int getStocks() { return stocks; }
    public String getSupplier() { return supplier; }
}
