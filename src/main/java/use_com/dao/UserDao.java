package use_com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import use_com.model.User;
import use_com.util.DBUtil;


public class UserDao {
// 登录
	public static boolean login(int uid,String password) {
		Connection conn = DBUtil.getCon();
		String sql = "select uid,upass from user where uid=? and upass=?";
		
		ResultSet rs;
		PreparedStatement stm = null;
		boolean sta = false;
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, uid);
			stm.setString(2, password);
			
			rs=stm.executeQuery();
			if(rs.next()) {
				sta = true;
			}else {
				sta = false;
			}
			return sta;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// 增加
	public static boolean regist(int uid,String password,String uname,String usex,int uage,double utel) {
		Connection conn = DBUtil.getCon();
		String sql = "insert into user (uid,upass,uname,usex,uage,utel,ucondition,udescripe) values(?,?,?,?,?,?,?,'');";
		
		int a=0;
		PreparedStatement stm = null;
		boolean sta = false;
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, uid);
			stm.setString(2, password);
			stm.setString(3, uname);
			stm.setString(4, usex);
			stm.setInt(5, uage);
			stm.setDouble(6, utel);
			stm.setInt(7, 0);
			
			
			
			a=stm.executeUpdate();
			if(a==0) {
				sta = false;
			}else {
				sta = true;
			}
			return sta;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
//修改个人信息
	public static boolean chanage(int uid,String upass,String uname,String usex,int uage,double utel,int ucondition,String udescripe) {
		Connection conn = DBUtil.getCon();
		String sql = "UPDATE user SET upass=?,uname=?,usex=?,uage=?,utel=?,ucondition=?,udescripe=? where uid=?;";
		
		int a=0;
		PreparedStatement stm = null;
		boolean sta = false;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, upass);
			stm.setString(2, uname);
			stm.setString(3, usex);
			stm.setInt(4, uage);
			stm.setDouble(5, utel);
			stm.setInt(6, ucondition);
			stm.setString(7, udescripe);
			stm.setInt(8, uid);
			
			
			a=stm.executeUpdate();
			if(a==0) {
				sta = false;
			}else {
				sta = true;
			}
			return sta;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
//删除个人信息	
	public static boolean delete(int uid) {
		Connection conn = DBUtil.getCon();
		String sql = "DELETE FROM user WHERE uid=?;";
		
		int a=0;
		PreparedStatement stm = null;
		boolean sta = false;
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, uid);
			a=stm.executeUpdate();
			if(a==0) {
				sta = false;
			}else {
				sta = true;
			}
			return sta;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
//查询所有集合	
	public static ArrayList<User> get_List() {
		ArrayList<User> tag_Array = new ArrayList<User>();//建立一个数组集合
		Connection conn = DBUtil.getCon();
		String sql = "select * FROM user";
		
		ResultSet rs;	
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			rs=stm.executeQuery();
			while(rs.next()) {
				User tag = new User();
				tag.setUid(rs.getInt("uid"));
				tag.setUname(rs.getString("uname"));
				tag.setUpass(rs.getInt("upass"));
				tag.setUsex(rs.getString("usex"));
				tag.setUage(rs.getInt("uage"));
				tag.setUtel(rs.getDouble("utel"));
				tag.setUcondition(rs.getInt("ucondition"));
				tag.setUdescripe(rs.getString("udescripe"));
				tag_Array.add(tag);
			}rs.close();
			stm.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return tag_Array;
	}	
	
	//查询个人集合	
		public static ArrayList<User> get_List(String uid) {
			ArrayList<User> tag_Array = new ArrayList<User>();//建立一个数组集合
			Connection conn = DBUtil.getCon();
			String sql = "select * FROM user where uid=?";
			
			ResultSet rs;	
			PreparedStatement stm = null;
			try {
				stm = conn.prepareStatement(sql);
				stm.setString(1, uid);
				rs=stm.executeQuery();
				while(rs.next()) {
					User tag = new User();
					tag.setUid(rs.getInt("uid"));
					tag.setUname(rs.getString("uname"));
					tag.setUpass(rs.getInt("upass"));
					tag.setUsex(rs.getString("usex"));
					tag.setUage(rs.getInt("uage"));
					tag.setUtel(rs.getDouble("utel"));
					tag.setUcondition(rs.getInt("ucondition"));
					tag.setUdescripe(rs.getString("udescripe"));
					tag_Array.add(tag);
				}rs.close();
				stm.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return tag_Array;
		}

}

