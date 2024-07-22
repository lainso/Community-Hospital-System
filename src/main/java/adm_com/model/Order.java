package adm_com.model;

public class Order {
    // 订单id
    private int oid;
    // 订单时间
    private String otime;
    // 医生id
    private int did;
    // 用户id
    private int uid;
    // 诊断信息
    private String oresult;
    // 开药信息
    private String omedicine;
    // 订单金额
    private double omoney;

    // 生成getter和setter
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getOtime() {
        return otime;
    }

    public void setOtime(String otime) {
        this.otime = otime;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getOresult() {
        return oresult;
    }

    public void setOresult(String oresult) {
        this.oresult = oresult;
    }

    public String getOmedicine() {
        return omedicine;
    }

    public void setOmedicine(String omedicine) {
        this.omedicine = omedicine;
    }

    public double getOmoney() {
        return omoney;
    }

    public void setOmoney(double omoney) {
        this.omoney = omoney;
    }
}
