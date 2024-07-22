package adm_com.model;

public class Goods {
	// 物资id
	private int gid;
	// 物资名称
	private String gname;
	// 物资库存
	private int gnum;
	// 物资单价
    private double gprice;

	// 生成getter和setter，文中省略
	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getGnum() {
		return gnum;
	}

	public void setGnum(int gnum) {
		this.gnum = gnum;
	}

	public double getGprice() {
		return gprice;
	}

	public void setGprice(double gprice) {
		this.gprice = gprice;
	}
}
