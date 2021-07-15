
package Bai1;
public class LoaiSanPham {
    private int MaLoaiSP;
    private String TenLoaiSP;
    public int getMaLoaiSP() {
        return MaLoaiSP;
    }
    public void setMaLoaiSP(int MaLoaiSP) {
        this.MaLoaiSP = MaLoaiSP;
    }
    public String getTenLoaiSP() {
        return TenLoaiSP;
    }
    public void setTenLoaiSP(String TenLoaiSP) {
        this.TenLoaiSP = TenLoaiSP;
    }
    public LoaiSanPham() {
    }
    public LoaiSanPham(int MaLoaiSP, String TenLoaiSP) {
        this.MaLoaiSP = MaLoaiSP;
        this.TenLoaiSP = TenLoaiSP;
    }

    @Override
    public String toString() {
        return   MaLoaiSP + "-" + TenLoaiSP ;
    }
    
}
