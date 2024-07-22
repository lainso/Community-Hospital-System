package doc_com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import doc_com.model.Doctor;
import doc_com.util.DBUtil;

public class DoctorDao {
	
	public static int ldid;
	
    //登录功能
    public static boolean login(int did,String dpass) {
		Connection conn = DBUtil.getCon();
		String sql = "select * from doctor where did=? and dpass=?";
		ResultSet rs;
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, did);
			stm.setString(2, dpass);
			ldid = did;
			System.out.print(ldid);
			rs=stm.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
    }

	// 添加
    public static boolean add(int did, String dpass, String dname,String dsex,String droom, Long dtel, int djob){
        Connection con = DBUtil.getCon();
        String sql = "INSERT INTO doctor (`did`, `dpass`, `dname`, `dsex`, `droom`, `dtel`, `djob`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stm = null;
        int sta = 0;
        try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, did);
            stm.setString(2, dpass);
            stm.setString(3, dname);
            stm.setString(4, dsex);
            stm.setString(5, droom);
            stm.setLong(6, dtel);
            stm.setInt(7, djob);
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
    public static boolean fix(String dpass, String dname,String dsex,String droom, Long dtel, int djob, int did){
        Connection con = DBUtil.getCon();
        String sql = "update doctor set dpass=?, dname=?, dsex=?, droom=?, dtel=?, djob=? where did=?";
        PreparedStatement stm = null;
        int sta = 0;
        try {
			stm = con.prepareStatement(sql);
            stm.setString(1, dpass);
            stm.setString(2, dname);
            stm.setString(3, dsex);
            stm.setString(4, droom);
            stm.setLong(5, dtel);
            stm.setInt(6, djob);
            stm.setInt(7, did);
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
    public static boolean delete(int did){
        Connection con = DBUtil.getCon();
        String sql = "delete from doctor where did=?";
        PreparedStatement stm = null;
        int sta = 0;
        try {
			stm = con.prepareStatement(sql);
            stm.setInt(1, did);
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
	public static ArrayList<Doctor> getList(){
		ArrayList<Doctor> tag_array = new ArrayList<Doctor>();

		Connection conn = DBUtil.getCon();
		String sql = "select * from doctor";

		ResultSet rs;
		PreparedStatement stm = null;

		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()) {
				Doctor tag = new Doctor();
				tag.setDid(rs.getInt("did"));
				tag.setDpass(rs.getString("dpass"));
				tag.setDname(rs.getString("dname"));
				tag.setDsex(rs.getString("dsex"));
				tag.setDroom(rs.getString("droom"));
				tag.setDtel(rs.getLong("dtel"));
				tag.setDjob(rs.getInt("djob"));
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
	public static ArrayList<Doctor> getList(int did){
		ArrayList<Doctor> tag_array = new ArrayList<Doctor>();

		Connection conn = DBUtil.getCon();
		String sql = "select * from doctor where did=?";

		ResultSet rs;
		PreparedStatement stm = null;

		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, did);
			rs = stm.executeQuery();
			while(rs.next()) {
				Doctor tag = new Doctor();
				tag.setDid(rs.getInt("did"));
				tag.setDpass(rs.getString("dpass"));
				tag.setDname(rs.getString("dname"));
				tag.setDsex(rs.getString("dsex"));
				tag.setDroom(rs.getString("droom"));
				tag.setDtel(rs.getLong("dtel"));
				tag.setDjob(rs.getInt("djob"));
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
