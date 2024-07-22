package adm_com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import adm_com.model.Doctor;
import adm_com.util.DBUtil;

public class DoctorDao {
    // 登录
    public static boolean login(int did,String dpass) {
		// 获取数据库连接
		Connection conn = DBUtil.getCon();
		// 定义sql语句，使用预处理防止SQL注入，提升系统安全性
		String sql = "select * from doctor where did=? and dpass=? and djob=0";
		// 定义结果集以方便后续操作
		ResultSet rs;
		// 预处理对象
		PreparedStatement stm = null;
		// try...catch保障系统完备性
		try {
			// 连接数据库
			stm = conn.prepareStatement(sql);
			// 预处理填入医生的id和密码
			stm.setInt(1, did);
			stm.setString(2, dpass);

			// 尝试获取对象，获取成功则证明数据库里面有这条记录，则登录成功
			rs=stm.executeQuery();
			if(rs.next()) {
				// 返回结果
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			// 连接不上，捕获打印报错，返回结果
			e.printStackTrace();
			return false;
		}
    }

	// 添加，与上面流程大同小异，往下只标注有差异的地方
    public static boolean add(int did, String dpass, String dname,String dsex,String droom, Long dtel, int djob){
        Connection con = DBUtil.getCon();
        String sql = "INSERT INTO doctor (`did`, `dpass`, `dname`, `dsex`, `droom`, `dtel`, `djob`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stm = null;
        // 定义一个状态码，用来接收数据库执行返回的情况，默认赋值执行失败
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
            // 更新状态码，如果失败则会返回0
			sta = stm.executeUpdate();
            if(sta==0) {
				return false;
            }else {
				// 状态码不为零则表述执行添加成功
				return true;
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
    
	// 修改，仅标注差异
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
    
	// 删除，仅标注差异
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

    // 查询所有记录，仅标注差异
	public static ArrayList<Doctor> getList(){
		// 创建一个医生数组对象用来接收查询的所有的结果
		ArrayList<Doctor> tag_array = new ArrayList<Doctor>();

		Connection conn = DBUtil.getCon();
		String sql = "select * from doctor";

		ResultSet rs;
		PreparedStatement stm = null;

		try {
			stm = conn.prepareStatement(sql);
			// 执行查询
			rs = stm.executeQuery();
			// 当resultset还有内容时...
			while(rs.next()) {
				// 创建一个链式的医生对象用来记录，最后丢数组里面
				Doctor tag = new Doctor();
				tag.setDid(rs.getInt("did"));
				tag.setDpass(rs.getString("dpass"));
				tag.setDname(rs.getString("dname"));
				tag.setDsex(rs.getString("dsex"));
				tag.setDroom(rs.getString("droom"));
				tag.setDtel(rs.getLong("dtel"));
				tag.setDjob(rs.getInt("djob"));
				// 将临时的医生对象写入数组中，然后开始下一轮，覆盖原有临时对象（下一个医生）
				tag_array.add(tag);
			}
			// resultset用完就关掉
			rs.close();
			// 预处理也关掉
			stm.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		// 返回医生数组
		return tag_array;
	}

	// 查询单条记录，仅标注差异
	public static ArrayList<Doctor> getList(int did){
		ArrayList<Doctor> tag_array = new ArrayList<Doctor>();

		Connection conn = DBUtil.getCon();
		String sql = "select * from doctor where did=?";

		ResultSet rs;
		PreparedStatement stm = null;

		try {
			stm = conn.prepareStatement(sql);
			// 相比上面就是多了一个使用id过滤，通过传参类型的不同，得以区分开来
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
