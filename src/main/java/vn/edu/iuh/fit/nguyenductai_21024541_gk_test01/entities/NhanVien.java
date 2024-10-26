package vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "NHANVIEN")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANV")
    private Long maNV;  // Đổi thành kiểu Long để Hibernate quản lý tự động tăng

    @Column(name = "TENNV")
    private String tenNV;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "DIACHI")
    private String diaChi;

    @Column(name = "DIENTHOAI")
    private String dienThoai;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MAPHONGBAN")
    private PhongBan phongBan;



    // Getters and Setters

    public Long getMaNV() {
        return maNV;
    }

    public void setMaNV(Long maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }

    // Constructors
    public NhanVien(String tenNV, String email, String diaChi, String dienThoai, PhongBan phongBan) {
        this.tenNV = tenNV;
        this.email = email;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.phongBan = phongBan;
    }

    public NhanVien() {
    }
}
