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
public class product_ingredient {
    private int productIngredientId;
    private int ingredientId;
    private int productId;

    public product_ingredient(int productIngredientId, int ingredientId, int productId) {
        this.productIngredientId = productIngredientId;
        this.ingredientId = ingredientId;
        this.productId = productId;
    }

    public int getProductIngredientId() { return productIngredientId; }
    public int getIngredientId() { return ingredientId; }
    public int getProductId() { return productId; }
}
