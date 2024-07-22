package doc_com.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBUtil {
    public static String username = "hospital";
    public static String password = "ifDtHXJWzDGaj2z5";
    public static String database = "hospital";
    public static String url = "jdbc:mysql://8.134.179.231:3306/"+database+"?characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getCon(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(url,username,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }

    public static void CloseDB(ResultSet rs, PreparedStatement ps,Connection con){
        if(rs != null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(ps != null){
            try {
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(con != null){
            try {
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
