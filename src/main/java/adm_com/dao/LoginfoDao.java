package adm_com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import adm_com.model.Loginfo;
import adm_com.util.DBUtil;

public class LoginfoDao {
	// 添加
    public static boolean add(int lid, String lname, String ltime){
        Connection con = DBUtil.getCon();
        String sql = "INSERT INTO loginfo (`lid`, `lname`, `ltime`) VALUES (?, ?, ?)";
        PreparedStatement stm = null;
        int sta = 0;
        try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, lid);
            stm.setString(2, lname);
            stm.setString(3, ltime);
            sta = stm.executeUpdate();
            if(sta==0) {
				return false;
            }else {
				return true;
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
    
	// 修改
    public static boolean fix(String lname, String ltime, int lid){
        Connection con = DBUtil.getCon();
        String sql = "update loginfo set lname=?, ltime=? where lid=?";
        PreparedStatement stm = null;
        int sta = 0;
        try {
			stm = con.prepareStatement(sql);
            stm.setString(1, lname);
            stm.setString(2, ltime);
            stm.setInt(3, lid);
            sta = stm.executeUpdate();
            if(sta==0) {
				return false;
            }else {
				return true;
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
    
	// 删除
    public static boolean delete(int lid){
        Connection con = DBUtil.getCon();
        String sql = "delete from loginfo where lid=?";
        PreparedStatement stm = null;
        int sta = 0;
        try {
			stm = con.prepareStatement(sql);
            stm.setInt(1, lid);
            sta = stm.executeUpdate();
            if(sta==0) {
				return false;
            }else {
				return true;
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }

    // 查询所有记录
	public static ArrayList<Loginfo> getList(){
		ArrayList<Loginfo> tag_array = new ArrayList<Loginfo>();

		Connection conn = DBUtil.getCon();
		String sql = "select * from loginfo";

		ResultSet rs;
		PreparedStatement stm = null;

		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()) {
				Loginfo tag = new Loginfo();
				tag.setLid(rs.getInt("lid"));
				tag.setLname(rs.getString("lname"));
				tag.setLtime(rs.getString("ltime"));
				tag_array.add(tag);
			}
			rs.close();
			stm.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return tag_array;
	}

    // 查询单条记录
	public static ArrayList<Loginfo> getList(int lid){
		ArrayList<Loginfo> tag_array = new ArrayList<Loginfo>();

		Connection conn = DBUtil.getCon();
		String sql = "select * from loginfo where lid=?";

		ResultSet rs;
		PreparedStatement stm = null;

		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, lid);
			rs = stm.executeQuery();
			while(rs.next()) {
				Loginfo tag = new Loginfo();
				tag.setLid(rs.getInt("lid"));
				tag.setLname(rs.getString("lname"));
				tag.setLtime(rs.getString("ltime"));
				tag_array.add(tag);
			}
			rs.close();
			stm.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return tag_array;
	}
}
