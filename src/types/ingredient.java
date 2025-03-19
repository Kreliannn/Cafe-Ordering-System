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

    public ingredient(int ingredientId, String ingredientName) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
    }

    public int getIngredientId() { return ingredientId; }
    public String getIngredientName() { return ingredientName; }
}
