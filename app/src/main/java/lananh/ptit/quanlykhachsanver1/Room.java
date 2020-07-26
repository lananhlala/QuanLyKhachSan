package lananh.ptit.quanlykhachsanver1;

public class Room {
    private int soP;
    private int tangP;
    private String loaiP;
    private int giaP;
    private String trangthaiP;

    public Room() {
    }

    public Room(int soP, String loaiP, int giaP, int tangP) {
        this.soP = soP;
        this.loaiP = loaiP;
        this.giaP = giaP;
//        this.trangthaiP = trangthaiP;
        this.tangP = tangP;
    }

    public int getTangP() {
        return tangP;
    }

    public void setTangP(int tangP) {
        this.tangP = tangP;
    }

    public int getSoP() {
        return soP;
    }

    public void setSoP(int soP) {
        this.soP = soP;
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

    public String getTrangthaiP() {
        return trangthaiP;
    }

    public void setTrangthaiP(String trangthaiP) {
        this.trangthaiP = trangthaiP;
    }
}
