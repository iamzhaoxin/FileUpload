import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class init {
    public static void main(String[] arg){
        DBconnection db=new DBconnection();
        Connection conn=db.getConn();
        PreparedStatement stmt;
        String sql = "insert into work2 values (?,?)";

        try {
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            for (int i=2018040414;i<=2018040439;i++){
                stmt.setInt(1, i);
                stmt.setString(2, "0");
                stmt.executeUpdate();
            }
            stmt.setInt(1, 2017040362);
            stmt.setString(2, "0");
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
