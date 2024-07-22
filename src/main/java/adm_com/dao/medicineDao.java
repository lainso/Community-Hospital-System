package adm_com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import adm_com.model.Medicine;
import adm_com.util.DBUtil;

public class medicineDao {
	//添加药品信息
			public static boolean add(int mid,String mname,int mprice,int mnum,String mdate) {
				Connection conn = DBUtil.getCon();
				String sql = "insert into medicine (mid,mname,mprice,mnum,mdate) values (?,?,?,?,?);";
				
				int a=0;
				PreparedStatement stm = null;
				boolean sta = false;
				try {
					stm = conn.prepareStatement(sql);
					stm.setInt(1, mid);
					stm.setString(2, mname);
					stm.setInt(3, mprice);
					stm.setInt(4, mnum);
					stm.setString(5, mdate);
					
					
					
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
	
	//修改药品信息
		public static boolean chanage(int mid,String mname,int mprice,int mnum,String mdate) {
			Connection conn = DBUtil.getCon();
			String sql = "UPDATE medicine SET mname=?,mprice=?,mnum=?,mdate=? where mid=?;";
			
			int a=0;
			PreparedStatement stm = null;
			boolean sta = false;
			try {
				stm = conn.prepareStatement(sql);
				stm.setString(1, mname);
				stm.setInt(2, mprice);
				stm.setInt(3, mnum);
				stm.setString(4, mdate);
				stm.setInt(5, mid);
				
				
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
		
	//删除药品信息	
		public static boolean delete(int mid) {
			Connection conn = DBUtil.getCon();
			String sql = "DELETE FROM medicine WHERE mid=?;";
			
			int a=0;
			PreparedStatement stm = null;
			boolean sta = false;
			try {
				stm = conn.prepareStatement(sql);
				stm.setInt(1, mid);
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
		
	//查询所有药品集合	
		public static ArrayList<Medicine> get_List() {
			ArrayList<Medicine> tag_Array = new ArrayList<Medicine>();//建立一个数组集合
			Connection conn = DBUtil.getCon();
			String sql = "select * FROM medicine";
			
			ResultSet rs;	
			PreparedStatement stm = null;
			try {
				stm = conn.prepareStatement(sql);
				rs=stm.executeQuery();
				while(rs.next()) {
					Medicine tag = new Medicine();
					tag.setMid(rs.getInt("mid"));
					tag.setMname(rs.getString("mname"));
					tag.setMprice(rs.getInt("mprice"));
					tag.setMnum(rs.getInt("mnum"));
					tag.setMdate(rs.getString("mdate"));
					tag_Array.add(tag);
				}rs.close();
				stm.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return tag_Array;
		}	
		
		//查询单个药品集合	
			public static ArrayList<Medicine> get_List(String mid) {
				ArrayList<Medicine> tag_Array = new ArrayList<Medicine>();//建立一个数组集合
				Connection conn = DBUtil.getCon();
				String sql = "select * FROM medicine where mid=?";
				
				ResultSet rs;	
				PreparedStatement stm = null;
				try {
					stm = conn.prepareStatement(sql);
					stm.setString(1, mid);
					rs=stm.executeQuery();
					while(rs.next()) {
						Medicine tag = new Medicine();
						tag.setMid(rs.getInt("mid"));
						tag.setMname(rs.getString("mname"));
						tag.setMprice(rs.getInt("mprice"));
						tag.setMnum(rs.getInt("mnum"));
						tag.setMdate(rs.getString("mdate"));
						tag_Array.add(tag);
					}rs.close();
					stm.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return tag_Array;
			}
}
