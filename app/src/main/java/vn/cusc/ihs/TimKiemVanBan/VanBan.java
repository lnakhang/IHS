package vn.cusc.ihs.TimKiemVanBan;

/**
 * Created by lnakhang on 8/15/2016.
 */
public class VanBan {
    String kyHieuVanBan;
    String ngayKyVanBan;
    String nguoiKyVanBan;
    String trichYeu;
    String tenCoQuan;
    Integer namBanHanhVanBan;
    String tapTinVanban;
    String ColumnContains;

    public VanBan(String kyHieuVanBan, String ngayKyVanBan, String nguoiKyVanBan, String trichYeu, String tenCoQuan, Integer namBanHanhVanBan, String tapTinVanban, String columnContains) {
        this.kyHieuVanBan = kyHieuVanBan;
        this.ngayKyVanBan = ngayKyVanBan;
        this.nguoiKyVanBan = nguoiKyVanBan;
        this.trichYeu = trichYeu;
        this.tenCoQuan = tenCoQuan;
        this.namBanHanhVanBan = namBanHanhVanBan;
        this.tapTinVanban = tapTinVanban;
        this.ColumnContains = columnContains;
    }

    public String getKyHieuVanBan() {
        return kyHieuVanBan;
    }

    public void setKyHieuVanBan(String kyHieuVanBan) {
        this.kyHieuVanBan = kyHieuVanBan;
    }

    public String getNgayKyVanBan() {
        return ngayKyVanBan;
    }

    public void setNgayKyVanBan(String ngayKyVanBan) {
        this.ngayKyVanBan = ngayKyVanBan;
    }

    public String getNguoiKyVanBan() {
        return nguoiKyVanBan;
    }

    public void setNguoiKyVanBan(String nguoiKyVanBan) {
        this.nguoiKyVanBan = nguoiKyVanBan;
    }

    public String getTrichYeu() {
        return trichYeu;
    }

    public void setTrichYeu(String trichYeu) {
        this.trichYeu = trichYeu;
    }

    public String getTenCoQuan() {
        return tenCoQuan;
    }

    public void setTenCoQuan(String tenCoQuan) {
        this.tenCoQuan = tenCoQuan;
    }

    public Integer getNamBanHanhVanBan() {
        return namBanHanhVanBan;
    }

    public void setNamBanHanhVanBan(Integer namBanHanhVanBan) {
        this.namBanHanhVanBan = namBanHanhVanBan;
    }

    public String getTapTinVanban() {
        return tapTinVanban;
    }

    public void setTapTinVanban(String tapTinVanban) {
        this.tapTinVanban = tapTinVanban;
    }

    public String getColumnContains() {
        return ColumnContains;
    }

    public void setColumnContains(String columnContains) {
        this.ColumnContains = columnContains;
    }
}
