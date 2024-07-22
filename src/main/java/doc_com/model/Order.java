package doc_com.model;

public class Order {
    private int oid;
    private String otime;
    private int did;
    private int uid;
    private String oresult;
    private String omedicine;
    private double omoney;

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
