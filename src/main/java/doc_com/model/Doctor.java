package doc_com.model;

public class Doctor {
    private int did;
    private String dpass;
    private String dname;
    private String dsex;
    private String droom;
    private long dtel;
    private int djob;

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

    public void setDjob(int djob) {
        if(djob==0 || djob==1 || djob==2){
            this.djob = djob;
        }else {
            this.djob = -1;
        }
    }

}
