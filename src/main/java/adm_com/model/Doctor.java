package adm_com.model;

public class Doctor {
    // 医生id，作为账号，也是主键
    private int did;
    // 医生密码
    private String dpass;
    // 医生姓名
    private String dname;
    // 医生性别
    private String dsex;
    // 医生所属科室
    private String droom;
    // 医生联系方式
    private long dtel;
    // 职位，0代表管理员，1代表医生，2代表户数
    private int djob;

    // 下面是生成的getter和setter
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDpass() {
        return dpass;
    }

    public void setDpass(String dpass) {
        this.dpass = dpass;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDsex() {
        return dsex;
    }

    public void setDsex(String dsex) {
        this.dsex = dsex;
    }

    public String getDroom() {
        return droom;
    }

    public void setDroom(String droom) {
        this.droom = droom;
    }

    public long getDtel() {
        return dtel;
    }

    public void setDtel(long dtel) {
        this.dtel = dtel;
    }

    public int getDjob() {
        return djob;
    }

    // 规范输入，如果输入了不合法的数字，会被调整到-1，代表设置职位失败
    public void setDjob(int djob) {
        if(djob==0 || djob==1 || djob==2){
            this.djob = djob;
        }else {
            this.djob = -1;
        }
    }

}
