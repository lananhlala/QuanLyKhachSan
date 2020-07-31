package lananh.ptit.thithuqlks;

public class Room {
    private int soP, tang;
    private String loaiP;
    private int giaP;
    private String trangthai;

    public Room() {
    }

    public Room(int soP, int tang, String loaiP, int giaP, String trangthai) {
        this.soP = soP;
        this.tang = tang;
        this.loaiP = loaiP;
        this.giaP = giaP;
        this.trangthai = trangthai;
    }
    public Room(int soP, int tang, String loaiP, int giaP) {
        this.soP = soP;
        this.tang = tang;
        this.loaiP = loaiP;
        this.giaP = giaP;
    }
    public int getSoP() {
        return soP;
    }

    public void setSoP(int soP) {
        this.soP = soP;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public String getLoaiP() {
        return loaiP;
    }

    public void setLoaiP(String loaiP) {
        this.loaiP = loaiP;
    }

    public int getGiaP() {
        return giaP;
    }

    public void setGiaP(int giaP) {
        this.giaP = giaP;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
}
