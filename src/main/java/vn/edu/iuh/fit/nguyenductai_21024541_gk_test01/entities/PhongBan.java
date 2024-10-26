package vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PHONGBAN")
public class PhongBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAPHONGBAN")
    private Long maPhongBan;  // Chuyển sang kiểu Long và tự động sinh ID

    @Column(name = "TENPHONGBAN")
    private String tenPhongBan;

    // Getters and Setters

    public Long getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(Long maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    // Constructors
    public PhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public PhongBan() {
    }
}
