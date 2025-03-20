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
public class inventory {
    private int inventoryId;
    private int supplierId;
    private int ingredientId;
    private int stocks;

    public inventory(int inventoryId, int supplierId, int ingredientId, int stocks) {
        this.inventoryId = inventoryId;
        this.supplierId = supplierId;
        this.ingredientId = ingredientId;
        this.stocks = stocks;
    }

    public int getInventoryId() { return inventoryId; }
    public int getSupplierId() { return supplierId; }
    public int getIngredientId() { return ingredientId; }
    public int getStocks() { return stocks; }
}
