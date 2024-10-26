package vn.edu.iuh.fit.nguyenductai_21024541_gk_test01;
import net.datafaker.Faker;
import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.entities.NhanVien;
import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.entities.PhongBan;
import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.services.NhanVienService;
import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.services.PhongBanService;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    private static final Faker faker = new Faker();
    private static final PhongBanService phongBanService = new PhongBanService();
    private static final NhanVienService nhanVienService = new NhanVienService();

    public static void generatePhongBan(int count) {
        for (int i = 0; i < count; i++) {
            String tenPhongBan = "Phòng " + faker.company().industry();
            PhongBan phongBan = new PhongBan(tenPhongBan);
            phongBanService.addPhongBan(phongBan);
        }
    }

    public static void generateNhanVien(int count) {
        List<PhongBan> phongBans = phongBanService.getAllPhongBan();
        for (int i = 0; i < count; i++) {
            String tenNV = faker.name().fullName();
            String email = faker.internet().emailAddress();
            String diaChi = faker.address().streetAddress();
            String dienThoai = faker.phoneNumber().cellPhone();

            PhongBan phongBan = phongBans.get(faker.random().nextInt(phongBans.size())); // Chọn ngẫu nhiên một phòng ban

            NhanVien nhanVien = new NhanVien(tenNV, email, diaChi, dienThoai, phongBan);
            nhanVienService.addNhanVien(nhanVien);
        }
    }

    public static void main(String[] args) {
        // Tạo dữ liệu cho phòng ban và nhân viên
        generatePhongBan(5);  // Tạo 5 phòng ban
        generateNhanVien(10); // Tạo 10 nhân viên
    }
}
