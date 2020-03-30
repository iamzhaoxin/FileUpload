package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    //数据库url、用户名和密码,驱动
    private static String url="jdbc:mariadb://182.92.174.151:3306/形政心得";
    private static String username="WEBlearner";
    private static String password="123456";
    private static String driver="org.mariadb.jdbc.Driver";

    private Connection conn;//导入连接包

    static {    //静态代码块，执行一次
        try{
            Class.forName(driver);  //连接驱动加载
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DBconnection(){
        try{    //把地址、用户名、密码，交给驱动管理
            conn= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn(){
        return conn;
    }
}
