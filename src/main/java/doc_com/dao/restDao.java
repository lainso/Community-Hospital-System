package doc_com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import doc_com.model.Rest;
import doc_com.util.DBUtil;

public class restDao {
	//添加请假信息
	public static boolean add(int rid,String rreason,String rstart,String rend,int rcondition) {
		Connection conn = DBUtil.getCon();
		String sql = "insert into rest (rid,did,rreason,rstart,rend,rcondition) values (?,?,?,?,?,?);";
		
		int a=0;
		PreparedStatement stm = null;
		boolean sta = false;
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, rid);
			stm.setInt(2, DoctorDao.ldid);
			stm.setString(3, rreason);
			stm.setString(4, rstart);
			stm.setString(5, rend);
			stm.setInt(6, rcondition);
			
			
			
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

//修改请假信息
public static boolean chanage(int rid,String rreason,String rstart,String rend,int rcondition) {
	Connection conn = DBUtil.getCon();
	String sql = "UPDATE rest SET did=?,rreason=?,rstart=?,rend=?,rcondition=? where rid=? and did=?;";
	
	int a=0;
	PreparedStatement stm = null;
	boolean sta = false;
	try {
		stm = conn.prepareStatement(sql);
		stm.setInt(1, DoctorDao.ldid);
		stm.setString(2, rreason);
		stm.setString(3, rstart);
		stm.setString(4, rend);
		stm.setInt(5, rcondition);
		stm.setInt(6, rid);
		stm.setInt(7, DoctorDao.ldid);
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

//删除请假信息	
public static boolean delete(int rid) {
	Connection conn = DBUtil.getCon();
	String sql = "DELETE FROM rest WHERE rid=? and did=?;";
	
	int a=0;
	PreparedStatement stm = null;
	boolean sta = false;
	try {
		stm = conn.prepareStatement(sql);
		stm.setInt(1, rid);
		stm.setInt(2, DoctorDao.ldid);
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

//查询所有请假集合	
public static ArrayList<Rest> get_List() {
	ArrayList<Rest> tag_Array = new ArrayList<Rest>();//建立一个数组集合
	Connection conn = DBUtil.getCon();
	String sql = "select * FROM rest where did=?";
	
	ResultSet rs;	
	PreparedStatement stm = null;
	try {
		stm = conn.prepareStatement(sql);
		stm.setInt(1, DoctorDao.ldid);
		rs=stm.executeQuery();
		while(rs.next()) {
			Rest tag = new Rest();
			tag.setRid(rs.getInt("rid"));
			tag.setRreason(rs.getString("rreason"));
			tag.setRstart(rs.getString("rstart"));
			tag.setRend(rs.getString("rend"));
			tag_Array.add(tag);
		}rs.close();
		stm.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return tag_Array;
}	

//查询单个请假集合	
	public static ArrayList<Rest> get_List(String mid) {
		ArrayList<Rest> tag_Array = new ArrayList<Rest>();//建立一个数组集合
		Connection conn = DBUtil.getCon();
		String sql = "select * FROM rest where rid=? and did=?";
		
		ResultSet rs;	
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, mid);
			stm.setInt(2, DoctorDao.ldid);
			rs=stm.executeQuery();
			while(rs.next()) {
				Rest tag = new Rest();
				tag.setRid(rs.getInt("rid"));
				tag.setRreason(rs.getString("rreason"));
				tag.setRstart(rs.getString("rstart"));
				tag.setRend(rs.getString("rend"));
				tag_Array.add(tag);
			}rs.close();
			stm.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return tag_Array;
	}
}
