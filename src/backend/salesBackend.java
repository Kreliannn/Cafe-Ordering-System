
package backend;
import utils.customHooks;
import types.*;
import backend.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class salesBackend extends database{
    
    public  int getSales()
    {
         try{
            String sql = "SELECT sum(payment_amount) as sales FROM payment";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                return rs.getInt("sales");
            }
            
        } catch(Exception e){
            System.out.println(e);
        }
         return 0;
    }
    
}
