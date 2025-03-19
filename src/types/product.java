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
public class product {
        private int productId;
    private String productName;
    private int price;
    private String size;
    private String image;

    public product(int productId, String productName, int price, String size, String image) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.size = size;
        this.image = image;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getPrice() { return price; }
    public String getSize() { return size; }
    public String getImage() { return image; }
}
