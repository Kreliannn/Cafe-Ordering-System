
package backend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class database {
    private Connection conn;

    // Constructor - Establishes Connection
    public database() {
        try {
            conn = DriverManager.getConnection(
            "jdbc:mysql://127.0.0.1:3306/pos_schema",
            "root",
            "impoyski0501"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
