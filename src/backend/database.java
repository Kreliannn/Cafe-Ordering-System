
package backend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class database {
    protected Connection conn;
    protected String name = "krel";
    // Constructor - Establishes Connection
    public database() {
        try {
            conn = DriverManager.getConnection(
            "jdbc:mysql://127.0.0.1:3306/seranatea",
            "root",
            "impoyski0501"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void test()
    {
        System.out.println("working");
    }
}
