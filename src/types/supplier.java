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
public class supplier {
    private int supplierId;
    private String supplierName;

    public supplier(int supplierId, String supplierName) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
    }

    public int getSupplierId() { return supplierId; }
    public String getSupplierName() { return supplierName; }
}
