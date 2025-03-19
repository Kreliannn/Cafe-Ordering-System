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
public class customer {
    private int employeeId;
    private String name;
    private String username;
    private String password;

    public customer(int employeeId, String name, String username, String password) {
        this.employeeId = employeeId;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
