package doc_com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import doc_com.model.Order;
import doc_com.util.DBUtil;

public class OrderDao {
	
	// 添加
    public static boolean add(int oid, String otime, int uid, String oresult, String omedicine, double omoney){ 	
        Connection con = DBUtil.getCon();
        String sql = "INSERT INTO `order` (`oid`, `otime`, `did`, `uid`, `oresult`, `omedicine`, `omoney`) VALUES (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement stm = null;
        int sta = 0;
        try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, oid);
            stm.setString(2, otime);
            stm.setInt(3, DoctorDao.ldid);
            stm.setInt(4, uid);
            stm.setString(5, oresult);
            stm.setString(6, omedicine);
            stm.setDouble(7, omoney);
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
    public static boolean fix(String otime, int uid, String oresult, String omedicine, double omoney, int oid){
        Connection con = DBUtil.getCon();
        String sql = "update `order` set `otime`=?, `did`=?, `uid`=?, `oresult`=?, `omedicine`=?, `omoney`=? where `oid`=?";
        PreparedStatement stm = null;
        int sta = 0;
        try {
			stm = con.prepareStatement(sql);
            stm.setString(1, otime);
            stm.setInt(2, DoctorDao.ldid);
            stm.setInt(3, uid);
            stm.setString(4, oresult);
            stm.setString(5, omedicine);
            stm.setDouble(6, omoney);
            stm.setInt(7, oid);
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
    public static boolean delete(int oid){
        Connection con = DBUtil.getCon();
        String sql = "DELETE FROM `order` WHERE  `oid`=? and did=?";
        PreparedStatement stm = null;
        int sta = 0;
        try {
			stm = con.prepareStatement(sql);
            stm.setInt(1, oid);
            stm.setInt(2, DoctorDao.ldid);
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

    //查询所有的集合
	public static ArrayList<Order> getList(){
		ArrayList<Order> tag_array = new ArrayList<Order>();

		Connection conn = DBUtil.getCon();
		String sql = "SELECT  `oid`,  `otime`, `uid`, `oresult`,  `omedicine`,  `omoney` FROM `order`where did=?";

		ResultSet rs;
		PreparedStatement stm = null;

		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, DoctorDao.ldid);
			rs = stm.executeQuery();
			while(rs.next()) {
				Order tag = new Order();
				tag.setOid(rs.getInt("oid"));
				tag.setOtime(rs.getString("otime"));
				tag.setUid(rs.getInt("uid"));
				tag.setOresult(rs.getString("oresult"));
				tag.setOmedicine(rs.getString("omedicine"));
				tag.setOmoney(rs.getDouble("omoney"));
				tag_array.add(tag);
			}
			rs.close();
			stm.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return tag_array;
	}

    //查询单条数据
	public static ArrayList<Order> getList(int oid){
		ArrayList<Order> tag_array = new ArrayList<Order>();

		Connection conn = DBUtil.getCon();
		String sql = "SELECT  `oid`,  `otime`, `uid`, `oresult`,  `omedicine`,  `omoney` FROM `hospital`.`order` where oid=? and did=?";

		ResultSet rs;
		PreparedStatement stm = null;

		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, oid);
			stm.setInt(2, DoctorDao.ldid);
			rs = stm.executeQuery();
			while(rs.next()) {
				Order tag = new Order();
				tag.setOid(rs.getInt("oid"));
				tag.setOtime(rs.getString("otime"));
				tag.setUid(rs.getInt("uid"));
				tag.setOresult(rs.getString("oresult"));
				tag.setOmedicine(rs.getString("omedicine"));
				tag.setOmoney(rs.getDouble("omoney"));
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
