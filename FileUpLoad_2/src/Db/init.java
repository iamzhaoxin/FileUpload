package Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class init {
    public static void main(String[] arg){
        DBconnection db=new DBconnection();
        Connection conn=db.getConn();
        PreparedStatement stmt;
        String sql = "update 提交状态 set 状态=0 where 学号=?";

        try {
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            for (int i=2018040414;i<=2018040439;i++){
                //stmt.setString(1,table);
                stmt.setInt(1, i);
                stmt.executeUpdate();
            }
            //stmt.setString(1,table);
            stmt.setInt(1, 2017040362);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
