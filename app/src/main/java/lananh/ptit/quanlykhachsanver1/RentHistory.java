package lananh.ptit.quanlykhachsanver1;

public class RentHistory {
    private int soP;
    private String gioVao, gioRa;
    private int giaP, thanhTien;

    public RentHistory() {
    }

    public RentHistory(int soP, String gioVao, String gioRa, int thanhTien, int giaP) {
        this.soP = soP;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        this.thanhTien = thanhTien;
        this.giaP = giaP;
    }

    public int getSoP() {
        return soP;
    }

    public void setSoP(int soP) {
        this.soP = soP;
    }

    public int getGiaP() {
        return giaP;
    }

    public void setGiaP(int giaP) {
        this.giaP = giaP;
    }

    public String getGioVao() {
        return gioVao;
    }

    public void setGioVao(String gioVao) {
        this.gioVao = gioVao;
    }

    public String getGioRa() {
        return gioRa;
    }

    public void setGioRa(String gioRa) {
        this.gioRa = gioRa;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
}
