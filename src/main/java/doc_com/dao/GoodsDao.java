package doc_com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import doc_com.model.Goods;
import doc_com.util.DBUtil;

public class GoodsDao {
	// 添加
    public static boolean add(int gid, String gname, int gnum, double gprice){
        Connection con = DBUtil.getCon();
        String sql = "INSERT INTO goods (`gid`, `gname`, `gnum`, `gprice`) VALUES (?, ?, ?, ?)";
        PreparedStatement stm = null;
        int sta = 0;
        try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, gid);
            stm.setString(2, gname);
            stm.setInt(3, gnum);
            stm.setDouble(4, gprice);
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
    public static boolean fix(String gname, int gnum, double gprice, int gid){
        Connection con = DBUtil.getCon();
        String sql = "update goods set gname=?, gnum=?, gprice=? where gid=?";
        PreparedStatement stm = null;
        int sta = 0;
        try {
			stm = con.prepareStatement(sql);
            stm.setString(1, gname);
            stm.setInt(2, gnum);
            stm.setDouble(3, gprice);
            stm.setInt(4, gid);
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
    public static boolean delete(int gid){
        Connection con = DBUtil.getCon();
        String sql = "delete from goods where gid=?";
        PreparedStatement stm = null;
        int sta = 0;
        try {
			stm = con.prepareStatement(sql);
            stm.setInt(1, gid);
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
	public static ArrayList<Goods> getList(){
		ArrayList<Goods> tag_array = new ArrayList<Goods>();

		Connection conn = DBUtil.getCon();
		String sql = "select * from goods";

		ResultSet rs;
		PreparedStatement stm = null;

		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()) {
				Goods tag = new Goods();
				tag.setGid(rs.getInt("gid"));
				tag.setGname(rs.getString("gname"));
				tag.setGnum(rs.getInt("gnum"));
				tag.setGprice(rs.getDouble("gprice"));
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
	public static ArrayList<Goods> getList(int gid){
		ArrayList<Goods> tag_array = new ArrayList<Goods>();

		Connection conn = DBUtil.getCon();
		String sql = "select * from goods where gid=?";

		ResultSet rs;
		PreparedStatement stm = null;

		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, gid);
			rs = stm.executeQuery();
			while(rs.next()) {
				Goods tag = new Goods();
				tag.setGid(rs.getInt("gid"));
				tag.setGname(rs.getString("gname"));
				tag.setGnum(rs.getInt("gnum"));
				tag.setGprice(rs.getDouble("gprice"));
				tag_array.add(tag);
			}
			rs.close();
			stm.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return tag_array;
	}
	
	//根据名字查询单条数据
		public static ArrayList<Goods> getList1(String gname){
			ArrayList<Goods> tag_array = new ArrayList<Goods>();

			Connection conn = DBUtil.getCon();
			String sql = "select * from goods where gname=?";

			ResultSet rs;
			PreparedStatement stm = null;

			try {
				stm = conn.prepareStatement(sql);
				stm.setString(1, gname);
				rs = stm.executeQuery();
				while(rs.next()) {
					Goods tag = new Goods();
					tag.setGid(rs.getInt("gid"));
					tag.setGname(rs.getString("gname"));
					tag.setGnum(rs.getInt("gnum"));
					tag.setGprice(rs.getDouble("gprice"));
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
