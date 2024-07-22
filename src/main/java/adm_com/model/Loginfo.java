package adm_com.model;

public class Loginfo {
    // 记录id
    private int lid;
    // 登录账号名
    private String lname;
    // 登录时间
    private String ltime;

    // getter和setter，在文中省略
    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLtime() {
        return ltime;
    }

    public void setLtime(String ltime) {
        this.ltime = ltime;
    }
}
